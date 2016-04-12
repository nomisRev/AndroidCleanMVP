package be.vergauwen.simon.himura;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class MVPActivity<P extends MVPContract.Presenter> extends AppCompatActivity
    implements MVPContract.View {

    protected P presenter;

    protected abstract P createPresenter();

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}