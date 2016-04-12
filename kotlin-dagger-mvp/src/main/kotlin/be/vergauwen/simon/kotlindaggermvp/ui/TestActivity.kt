package be.vergauwen.simon.kotlindaggermvp.ui

import android.os.Bundle
import android.util.Log
import be.vergauwen.simon.himurakotlin.MVPDaggerActivity
import be.vergauwen.simon.kotlindaggermvp.MVPApplication

class TestActivity : MVPDaggerActivity<TestContract.View, TestPresenter, TestComponent>(), TestContract.View {

  var isThingsShown = false
    private set

  override fun createComponent(): TestComponent =
      DaggerTestComponent.builder().applicationComponent(MVPApplication.component).build()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.e("TestActivity", "onCreate()")
  }

  override fun onResume() {
    super.onResume()
    presenter.loadThings()
  }

  override fun onDestroy() {
    Log.e("TestActivity", "onDestroy()")
    super.onDestroy()

  }

  override fun showThings() {
    Log.e("TestActivity", ".showThings()")
    isThingsShown = true
  }

  fun presenterLoadThings() {
    presenter.loadThings()
  }

  fun testPresenterNotNull(): Boolean {
    return presenter != null;
  }
}