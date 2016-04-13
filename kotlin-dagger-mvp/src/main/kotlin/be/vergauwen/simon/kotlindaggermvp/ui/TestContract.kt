package be.vergauwen.simon.kotlindaggermvp.ui

import be.vergauwen.simon.himurakotlin.MVPContract

interface TestContract {
  interface View : MVPContract.View {
    fun showThings()
  }

  interface Presenter<V : View> : MVPContract.Presenter<V> {
    fun loadThings()
  }

  interface Component<V : View ,P : Presenter<V>> : MVPContract.Component<V,P>
}