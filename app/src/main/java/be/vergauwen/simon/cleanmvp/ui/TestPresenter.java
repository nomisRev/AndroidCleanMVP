package be.vergauwen.simon.cleanmvp.ui;

import android.content.Context;
import android.util.Log;
import be.vergauwen.simon.cleanmvp.mvp.MVPPresenter;
import javax.inject.Inject;

public class TestPresenter extends MVPPresenter<TestContract.View>
    implements TestContract.Presenter {

    private Context context;

    @Inject
    public TestPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(TestContract.View view) {
        super.attachView(view);
    }

    @Override
    public void loadThings() {
        Log.e("TestPresenter", ".loadThings()");
        getView().showThings();
    }
}
