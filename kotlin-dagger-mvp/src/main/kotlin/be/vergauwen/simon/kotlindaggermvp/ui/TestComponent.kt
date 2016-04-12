package be.vergauwen.simon.kotlindaggermvp.ui

import be.vergauwen.simon.himurakotlin.MVPContract
import be.vergauwen.simon.kotlindaggermvp.di.ActivityScope
import be.vergauwen.simon.kotlindaggermvp.di.ApplicationComponent
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface TestComponent : MVPContract.Component<TestContract.View, TestPresenter> {
  override fun presenter(): TestPresenter
}