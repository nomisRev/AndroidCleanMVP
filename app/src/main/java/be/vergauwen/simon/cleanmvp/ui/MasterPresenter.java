package be.vergauwen.simon.cleanmvp.ui;

import android.util.Log;
import be.vergauwen.simon.cleanmvp.mvp.MVPPresenter;

public class MasterPresenter extends MVPPresenter<MasterContract.View>
    implements MasterContract.Presenter {

    @Override
    public void attachView(MasterContract.View view) {
        super.attachView(view);
    }

    @Override
    public void loadThings() {
        Log.e("MasterPresenter",".loadThings()");
        getView().showThings();
    }
}
