package be.vergauwen.simon.kotlindaggermvp

import android.app.Application
import be.vergauwen.simon.kotlindaggermvp.di.ApplicationComponent
import be.vergauwen.simon.kotlindaggermvp.di.ApplicationModule
import be.vergauwen.simon.kotlindaggermvp.di.DaggerApplicationComponent

internal class MVPApplication : Application() {

  companion object {
    @JvmStatic lateinit var component: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()

    component = DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }
}