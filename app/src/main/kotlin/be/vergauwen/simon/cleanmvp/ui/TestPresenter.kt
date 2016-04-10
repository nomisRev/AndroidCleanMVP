package be.vergauwen.simon.cleanmvp.ui

import android.util.Log
import be.vergauwen.simon.cleanmvp.mvp.MVPPresenter

class TestPresenter : MVPPresenter<TestContract.View>(), TestContract.Presenter {

  override fun attachView(view: TestContract.View) {
    super.attachView(view)
  }

  override fun loadThings() {
    Log.e("TestPresenter", ".loadThings()")
    getView()?.showThings()
  }
}