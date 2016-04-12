package be.vergauwen.simon.himura;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class MVPDaggerActivity<P extends MVPContract.Presenter, C extends MVPContract.Component<P>>
    extends AppCompatActivity implements MVPContract.View {
    protected P presenter;
    protected C component;

    protected abstract void createComponent();

    protected P createPresenter() {
        return component.presenter();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createComponent();
        presenter = createPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}

