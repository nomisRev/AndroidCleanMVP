package be.vergauwen.simon.cleanmvp.ui;

import android.os.Bundle;
import android.util.Log;
import be.vergauwen.simon.himura.MVPActivity;

public class TestActivity extends MVPActivity<TestPresenter> implements TestContract.View {

    private final static String TAG = TestActivity.class.getName();
    private boolean thingsShown = false;

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter();
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
