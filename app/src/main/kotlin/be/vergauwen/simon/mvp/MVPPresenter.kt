package be.vergauwen.simon.mvp

import java.lang.ref.WeakReference

abstract class MVPPresenter<V : MVPContract.View> : MVPContract.Presenter<V> {
  private var viewRef: WeakReference<MVPContract.View>? = null

  override fun getView(): V? = if (viewRef != null) viewRef!!.get() as V? else null

  override fun attachView(view: MVPContract.View) {
    viewRef = WeakReference(view)
  }

  override fun detachView() {
    viewRef?.clear()
    viewRef = null
  }
}
