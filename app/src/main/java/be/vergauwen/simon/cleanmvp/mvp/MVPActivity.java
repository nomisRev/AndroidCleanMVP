package be.vergauwen.simon.cleanmvp.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class MVPActivity<P extends MVPContract.Presenter>
    extends AppCompatActivity
    implements MVPContract.View {
    private P presenter;

    protected abstract P createPresenter();

    @Override
    public final P presenter() {
        return presenter;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        presenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}

