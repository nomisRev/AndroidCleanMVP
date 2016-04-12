package be.vergauwen.simon.kotlinvanillamvp.ui

import android.util.Log
import be.vergauwen.simon.himurakotlin.MVPPresenter

class TestPresenter : MVPPresenter<TestContract.View>(), TestContract.Presenter {

  //////////////////////////////////////////////////////////////////////////////////////////////////
  // TestContract.Presenter Impl

  override fun loadThings() {
    Log.e("TestPresenter", ".loadThings()")
    getView()?.showThings()
  }
}