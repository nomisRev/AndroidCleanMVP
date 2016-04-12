package be.vergauwen.simon.kotlindaggermvp.di

import android.content.Context
import dagger.Component

@ApplicationScope
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
  val applicationContext: Context
}