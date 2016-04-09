package be.vergauwen.simon.cleanmvp.ui;

import android.util.Log;
import be.vergauwen.simon.cleanmvp.mvp.MVPPresenter;

public class TestPresenter extends MVPPresenter<TestContract.View>
    implements TestContract.Presenter {

    @Override
    public void attachView(TestContract.View view) {
        super.attachView(view);
    }

    @Override
    public void loadThings() {
        Log.e("TestPresenter",".loadThings()");
        getView().showThings();
    }
}
