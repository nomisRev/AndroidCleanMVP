package be.vergauwen.simon.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MVPDaggerBaseActivity<V : MVPContract.View, P : MVPContract.Presenter<V>,
    C : MVPContract.Component<V, P>> : AppCompatActivity(), MVPContract.View {

  protected val presenter: P by lazy { component.presenter() }
  protected val component: C by lazy { createComponent() }

  protected abstract fun createComponent(): C

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }
}

