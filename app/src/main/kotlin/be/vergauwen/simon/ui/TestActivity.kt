package be.vergauwen.simon.ui

import android.os.Bundle
import android.util.Log
import be.vergauwen.simon.MVPApplication
import be.vergauwen.simon.mvp.MVPDaggerBaseActivity

class TestActivity : MVPDaggerBaseActivity<TestContract.View, TestPresenter, TestComponent>(), TestContract.View {

  var isThingsShown = false
    private set

  override fun createComponent(): TestComponent {
    return DaggerTestComponent.builder().applicationComponent(MVPApplication.component).build()
  }

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
