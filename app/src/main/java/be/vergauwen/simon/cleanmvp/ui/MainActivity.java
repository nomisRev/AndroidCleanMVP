package be.vergauwen.simon.cleanmvp.ui;

import android.os.Bundle;
import android.util.Log;
import be.vergauwen.simon.cleanmvp.mvp.MVPActivity;

public class MainActivity extends MVPActivity<MasterPresenter> implements MasterContract.View {

    private final static String TAG = MainActivity.class.getName();

    //No need to check if there still is an instance. Only called in onCreate() so clean/fresh activity
    @Override
    protected MasterPresenter createPresenter() {
        return new MasterPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter().loadThings();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void showThings() {
        Log.e(TAG, ".showThings()");
    }
}
