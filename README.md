# AndroidCleanMVP

In the text below you will find all info about the demo.
We will not discuss the model as this is the structure of your data and is pretty straight forward.

## vanilla-mvp / kotlin-vanilla-mvp

* There is a different setup for Java/Kotlin because generics are handled differently. Kotlin is stricter than Java when it comes to generics.  More about that below.

* A setup with no libs.

* Presenter instance does not get retained over config change.
  * Presenter should not be responsible for retaining data during config change (Single responsibility principle by Robert C. Martin). The presenter should only be responsible for business logic, it can load/save states but does not retain them. Retaining data during config change is out of the scope of this demos, there are many different possibilities and many different use cases so think carefully before choosing a solution.

### Usage
##### MVPContract
  The `MVPContract` is the contract between View & Presenter. This means the contract of what functionality (methods) the view can rely on the presenter for and the other way around.
```
interface ExampleContract {
  interface View extends MVPContract.View {
    void showThings();
  }
  
  interface Presenter extends MVPContract.Presenter<View> {
     void loadThings();
  }
}
```
  In the above shown code, the view can rely on the presenter to retrieve (load) things. And in return when the presenter has retrieved things, it can rely on the view to show them.
  
  Since the Java/Kotlin code for the contract solely consist of interfaces, we will not discuss this any further.
  
##### MVPActivity

There is a very important difference between the Java and Kotlin code here. As mentioned above, Kotlin and Java handle generics differently. In the code comparison below it will become clear.
```
Java: 
public abstract class MVPActivity<P extends MVPContract.Presenter> extends AppCompatActivity implements MVPContract.View

Kotlin:
abstract class MVPAppCompatActivity<V : MVPContract.View, P : MVPContract.Presenter<V>> : AppCompatActivity(), MVPContract.View
```
When we inspect the base `MVPContract` you'll notice that the `Presenter` has a generic type, in Kotlin we're required to specify this generic type. And as a result we have to explicitly cast `MVPAppCompatActivity` to `V` when attaching it to the presenter.
```
public interface MVPContract {
  interface View {}

  interface Presenter<V extends View> {
     V getView();
    void attachView(V view);
    void detachView();
  }
```

In contrast to Kotlin Java will cast `MVPAppCompatActivity` to `V` under the hood, and for that reason you don't have to specify the generic the of the `Presenter`.

**All that is left to do is override the abstract class createPresenter() when defining your Activity and you're good to go**

##### MVPPresenter

```
Java: 
public abstract class MVPPresenter<V extends MVPContract.View> implements MVPContract.Presenter<V> 

Kotlin:
abstract class MVPPresenter<V : MVPContract.View> : MVPContract.Presenter<V>
```

There is no difference between the definition of the `MVPPresenter` in Java or Kotlin. All you need to do to setup your Presenter is extend the abstract class and override the methods you have defined in the contract.


## dagger-mvp / kotlin-dagger-mvp

* A setup with dagger. Presenter gets created by dagger with the necessary dependencies.

* All the principles from above remain the same. But to make this setup truly wonderful, we can use dagger to automatically create the presenters and inject them with the dependencies that we want.

* Again in this setup there is a minor difference between Kotlin and Java. The reason is the same as above
  >You'll notice that the Presenter has a generic type, in Kotlin we're required to specify this generic type.

* We add the following to the MVPContract, and when creating the view specific `Component` you can specify the dependencies your view requires in this component. But more about that below.
```
Java:
  interface Component<P extends Presenter> {
    P presenter();
  }

Kotlin:
  interface Component<V : View, P : Presenter<V>> {
    fun presenter(): P
  }
```

That was pretty straight forward, a minor change is also visible in the definition of the abstract BaseActivity class.

```
Java:
public abstract class MVPDaggerBaseActivity<P extends MVPContract.Presenter, C extends MVPContract.Component<P>> extends AppCompatActivity implements MVPContract.View 
  
Kotlin:
abstract class MVPDaggerBaseActivity<V : MVPContract.View, P : MVPContract.Presenter<V>, C : MVPContract.Component<V, P>> : AppCompatActivity(), MVPContract.View
```

##### MVPComponent

Now what is this magic MVPComponent?
The `MVPComponent`, is the component that belongs to your activity and that takes care of making presenter for you. And injects the `Presenter` with the dependencies that you want in your `Presenter`.

The `MVPComponent` does more than just that! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧

The MVPComponent
```
@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface TestComponent extends MVPContract.Component<TestPresenter> {
    TestPresenter presenter();
    Context applicationContext();
}
```

The constructor of TestPresenter
```
@Inject
public TestPresenter(TestDependency testDependency) {
  this.testDependency = testDependency;
}
```

The ApplicationComponent
```
@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context getApplicationContext();
    TestDependency getTestDependency();
}
```

Dagger sees that you need a `TestPresenter`, defined in `TestComponent` and wants to create it for you. While doing so, Dagger sees that your `TestPresenter` has a constructor annotated with the `@Inject` annotation and will see if it has any matching dependencies. Since `TestComponent` depends on `ApplicationComponent` the dependency `TestDependency` defined in `ApplicationComponent` will be provided/injected into the constructor of TestPresenter and **poof** you have a `TestPresenter` instance that is injected with the `TestDependency` instance created in our ApplicationModule.

Now we have the created `TestPresenter` available in our view trough the component.

**This method works extremely well to inject instances in your presenter, that can easily be mocked out for tests**

## Important notes

1. Calling view methods
 * There is a key difference between the Kotlin and the Java example. Kotlin has Null safety, and therefor when a view method gets called from the presenter an error should never occur. `.?` takes care of that for you. If the view is null, the method will simply not be called and there is no problem.
 
 * The same approach doesn't work in Java. When the view is null you will get a `NullPointerException`. Ah, our dear friend finally appears. No problem, just do a null check before calling the method or add a `boolean isViewAttached()` method to our `MVPPresenter` base class.

2. View lifecycle
 * With previous discussed issue, we are sure that when a view method gets called it occurs between `onCreate()` and `onDestroy()`. Another issue is the issue of state loss, `java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState`. There are other side effects that can occur because not building in protection for this, an example is launching an activity when the app is in background. But that topic is out of scope for this repo. Let's just say we want to prevent this.
 
 <img src="/save&restore-state.png" alt="Save & restore state">

 * As you can see in the above shown diagram `onRestoreInstanceState()` gets called between `onStart()` and `onResume()`, so the earliest point we should **resume** normal behavior is when `onResume()` gets called. The reasoning can be applied for `onSaveInstanceState()`, we will **pause** normal behavior when `onPause()` gets called.
 
 * Earlier I mentioned the single responsibility rule, the same applies here. The view should only handle UI, saving data state or other business logic that the presenter should deal with can still proceed as otherwise. For example, a network call can return a result after the view went in the background. Saving this data might be essential in order to show the correct data when the view comes into the foreground again.
 
 * There are serveral methods to solve this problem but they're out of the scope of this demo. The question you should ask yourself is, who (what) is responsible for solving this problem.
