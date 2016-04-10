package be.vergauwen.simon.cleanmvp.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MVPActivity<P : MVPContract.Presenter<MVPContract.View>> : AppCompatActivity(), MVPContract.View {

  protected val presenter: P by lazy { createPresenter() }
  protected abstract fun createPresenter(): P

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.attachView(this)
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }
}

