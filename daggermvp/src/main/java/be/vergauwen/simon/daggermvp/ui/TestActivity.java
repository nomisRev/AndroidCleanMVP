package be.vergauwen.simon.daggermvp.ui;

import android.os.Bundle;
import android.util.Log;
import be.vergauwen.simon.daggermvp.MVPApplication;
import be.vergauwen.simon.himura.MVPDaggerActivity;

public class TestActivity extends MVPDaggerActivity<TestPresenter, TestComponent>
    implements TestContract.View {

    private final static String TAG = TestActivity.class.getName();

    private boolean thingsShown = false;

    @Override
    protected void createComponent() {
        component = DaggerTestComponent.builder()
            .applicationComponent(MVPApplication.getComponent())
            .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadThings();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy()");
        super.onDestroy();

    }

    @Override
    public void showThings() {
        Log.e(TAG, ".showThings()");
        thingsShown = true;
    }

    public boolean isThingsShown() {
        return thingsShown;
    }

    public TestPresenter getPresenter() {
        return presenter;
    }
}