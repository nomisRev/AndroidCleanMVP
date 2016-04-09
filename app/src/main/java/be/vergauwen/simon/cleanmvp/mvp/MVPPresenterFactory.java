//package be.vergauwen.simon.cleanmvp.mvp;
//
//import android.support.annotation.Nullable;
//import java.lang.reflect.ParameterizedType;
//
///**
// * https://github.com/konmik/nucleus/blob/master/nucleus/src/main/java/nucleus/factory/ReflectionPresenterFactory.java
// *
// * This class represents a {@link PresenterFactory} that creates a presenter using {@link Class#newInstance()} method.
// *
// * @param <P> the type of the presenter.
// */
//public class MVPPresenterFactory<P extends MVPContract.Presenter> implements PresenterFactory<P> {
//
//    private Class<P> presenterClass;
//
//
//
//
//    @Nullable
//    public static <P extends MVPContract.Presenter> MVPPresenterFactory<P> fromViewClass(Class<?> viewClass) {
//        RequiresPresenter annotation = viewClass.getAnnotation(RequiresPresenter.class);
//        //noinspection unchecked
//        Class<P> presenterClass = annotation == null ? null : (Class<P>)annotation.value();
//        return presenterClass == null ? null : new MVPPresenterFactory<>(presenterClass);
//    }
//
//    public MVPPresenterFactory(Class<P> presenterClass) {
//        this.presenterClass = presenterClass;
//    }
//
//    @Override
//    public P createPresenter() {
//        return null;
//    }
//
//    public P createPresenter(Class<P> obj ) {
//
//        //return new MVPPresenter<MVPContract.View>();
//
//        //((Class<P) obj.getClass().getGenericSuperclass()).ge
//        //
//        //
//        //return (Class<P>)((ParameterizedType) obj.getClass().getGenericSuperclass())
//        //    .getActualTypeArguments()[0];
//
//
//        //try {
//        //    return presenterClass.newInstance();
//        //}
//        //catch (Exception e) {
//        //    throw new RuntimeException(e);
//        //}
//    }
//}
