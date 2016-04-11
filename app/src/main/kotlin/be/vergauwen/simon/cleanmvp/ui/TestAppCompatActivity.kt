package be.vergauwen.simon.cleanmvp.ui

import android.os.Bundle
import android.util.Log
import be.vergauwen.simon.cleanmvp.mvp.MVPAppCompatActivity

class TestAppCompatActivity : MVPAppCompatActivity<TestContract.View, TestPresenter>(), TestContract.View {

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // MVPAppCompatActivity Impl
  override fun createPresenter(): TestPresenter {
    return TestPresenter()
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // TestActivity Impl

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

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // TestContract.View Impl

  override fun showThings() {
    Log.e("TestActivity", ".showThings()")
    isThingsShown = true
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // For testing purpose only!!! When using this lib in the future you may assume this works!!

  var isThingsShown = false
    private set

  @Suppress("SENSELESS_COMPARISON") //Useless in kotlin => lazy assignment
  fun testPresenterNotNull() : Boolean{
    return presenter != null;
  }

  fun presenterLoadThings() {
    presenter.loadThings()
  }
}