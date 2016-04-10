package be.vergauwen.simon.mvp

interface MVPContract {
  interface View

  interface Presenter<V : View> {
    fun getView(): V?
    fun attachView(view: View)
    fun detachView()
  }

  interface Component<V : View, P : Presenter<V>> {
    fun presenter(): P
  }
}
