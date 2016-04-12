package be.vergauwen.simon.daggermvp.di;

import android.content.Context;
import dagger.Component;

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context getApplicationContext();
}