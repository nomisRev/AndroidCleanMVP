package be.vergauwen.simon.cleanmvp.mvp

interface MVPContract{
  interface View

  interface Presenter<V : View>{
    fun getView() : V?
    fun attachView(view : MVPContract.View)
    fun detachView()
  }
}