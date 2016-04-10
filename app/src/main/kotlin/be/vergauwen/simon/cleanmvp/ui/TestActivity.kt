package be.vergauwen.simon.cleanmvp.ui

import android.os.Bundle
import android.util.Log
import be.vergauwen.simon.cleanmvp.mvp.MVPActivity

class TestActivity : MVPActivity<TestContract.View, TestPresenter>(), TestContract.View {
  var isThingsShown = false
    private set

  override fun createPresenter(): TestPresenter {
    return TestPresenter()
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

  fun testPresenterNotNull() : Boolean{
    return presenter != null;
  }
}