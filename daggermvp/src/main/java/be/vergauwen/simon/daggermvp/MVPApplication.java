package be.vergauwen.simon.daggermvp;

import android.app.Application;
import be.vergauwen.simon.daggermvp.di.ApplicationComponent;
import be.vergauwen.simon.daggermvp.di.ApplicationModule;
import be.vergauwen.simon.daggermvp.di.DaggerApplicationComponent;

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