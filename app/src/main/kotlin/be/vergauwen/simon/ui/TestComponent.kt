package be.vergauwen.simon.ui

import be.vergauwen.simon.di.ActivityScope
import be.vergauwen.simon.di.ApplicationComponent
import be.vergauwen.simon.mvp.MVPContract
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface TestComponent : MVPContract.Component<TestContract.View, TestPresenter> {
  override fun presenter(): TestPresenter
}
