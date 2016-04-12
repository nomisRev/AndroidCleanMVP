package be.vergauwen.simon.kotlindaggermvp.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: Application) {

  @ApplicationScope
  @Provides
  fun provideApplicationContext(): Context {
    return application
  }
}