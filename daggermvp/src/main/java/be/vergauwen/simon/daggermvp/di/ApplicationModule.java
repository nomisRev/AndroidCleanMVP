package be.vergauwen.simon.daggermvp.di;

import android.content.Context;
import be.vergauwen.simon.daggermvp.MVPApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private MVPApplication application;

    public ApplicationModule(MVPApplication application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    public Context provideApplicationContext() {
        return application;
    }
}