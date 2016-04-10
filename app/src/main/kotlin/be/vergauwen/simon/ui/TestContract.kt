package be.vergauwen.simon.ui

import be.vergauwen.simon.mvp.MVPContract

interface TestContract {
  interface View : MVPContract.View {
    fun showThings()
  }

  interface Presenter : MVPContract.Presenter<View> {
    fun loadThings()
  }
}