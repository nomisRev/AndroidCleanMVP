package be.vergauwen.simon.kotlindaggermvp.ui

import android.content.Context
import android.util.Log
import be.vergauwen.simon.himurakotlin.MVPPresenter
import javax.inject.Inject


class TestPresenter
@Inject
constructor(private val context: Context) : MVPPresenter<TestContract.View>(), TestContract.Presenter<TestContract.View> {

  override fun loadThings() {
    Log.e("TestPresenter", ".loadThings()")
    getView()?.showThings()
  }
}