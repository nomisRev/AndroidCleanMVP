package be.vergauwen.simon

import android.app.Application
import be.vergauwen.simon.di.ApplicationComponent
import be.vergauwen.simon.di.ApplicationModule
import be.vergauwen.simon.di.DaggerApplicationComponent

internal class MVPApplication : Application() {

  companion object {
    lateinit var component: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()

    component = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }
}
