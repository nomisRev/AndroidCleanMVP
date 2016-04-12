package be.vergauwen.simon.daggermvp.ui;

import be.vergauwen.simon.daggermvp.di.ActivityScope;
import be.vergauwen.simon.daggermvp.di.ApplicationComponent;
import be.vergauwen.simon.himura.MVPContract;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface TestComponent extends MVPContract.Component<TestPresenter> {
    TestPresenter presenter();
}