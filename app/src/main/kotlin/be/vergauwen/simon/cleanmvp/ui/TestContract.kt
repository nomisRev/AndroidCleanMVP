package be.vergauwen.simon.cleanmvp.ui

import be.vergauwen.simon.cleanmvp.mvp.MVPContract

interface TestContract{
  interface View : MVPContract.View{
    fun showThings()
  }

  interface Presenter : MVPContract.Presenter<View>{
    fun loadThings()
  }
}