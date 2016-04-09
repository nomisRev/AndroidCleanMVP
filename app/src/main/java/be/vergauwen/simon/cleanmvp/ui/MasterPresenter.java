package be.vergauwen.simon.cleanmvp.ui;

import android.content.Context;
import android.util.Log;
import be.vergauwen.simon.cleanmvp.mvp.MVPPresenter;
import javax.inject.Inject;

public class MasterPresenter extends MVPPresenter<MasterContract.View>
    implements MasterContract.Presenter {

    private Context context;

    @Inject
    public MasterPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void attach(MasterContract.View view) {
        super.attach(view);
    }

    @Override
    public void loadThings() {
        Log.e("MasterPresenter", ".loadThings()");
        view().showThings();
    }
}
