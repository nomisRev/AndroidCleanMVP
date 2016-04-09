package be.vergauwen.simon.cleanmvp.ui;

import android.os.Bundle;
import android.util.Log;
import be.vergauwen.simon.cleanmvp.MVPApplication;
import be.vergauwen.simon.cleanmvp.mvp.MVPDaggerBaseActivity;

public class MasterActivity extends MVPDaggerBaseActivity<MasterPresenter, MasterComponent>
    implements MasterContract.View {

    private final static String TAG = MasterActivity.class.getName();

    @Override
    protected void createComponent() {
        component = DaggerMasterComponent.builder()
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
    }
}
