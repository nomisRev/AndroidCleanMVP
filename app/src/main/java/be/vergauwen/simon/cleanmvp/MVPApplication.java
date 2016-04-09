package be.vergauwen.simon.cleanmvp;

import android.app.Application;
import be.vergauwen.simon.cleanmvp.di.ApplicationComponent;
import be.vergauwen.simon.cleanmvp.di.ApplicationModule;
import be.vergauwen.simon.cleanmvp.di.DaggerApplicationComponent;

public class MVPApplication extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .build();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
