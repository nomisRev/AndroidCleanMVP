package be.vergauwen.simon.ui

import android.content.Context
import android.util.Log
import be.vergauwen.simon.mvp.MVPPresenter
import javax.inject.Inject

class TestPresenter
@Inject
constructor(private val context: Context) : MVPPresenter<TestContract.View>(), TestContract.Presenter {

  override fun loadThings() {
    Log.e("TestPresenter", ".loadThings()")
    getView()?.showThings()
  }
}
