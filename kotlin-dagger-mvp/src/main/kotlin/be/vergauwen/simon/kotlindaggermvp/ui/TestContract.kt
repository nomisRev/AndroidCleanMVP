package be.vergauwen.simon.kotlindaggermvp.ui

import be.vergauwen.simon.himurakotlin.MVPContract

interface TestContract {
  interface View : MVPContract.View {
    fun showThings()
  }

  interface Presenter : MVPContract.Presenter<View> {
    fun loadThings()
  }
}