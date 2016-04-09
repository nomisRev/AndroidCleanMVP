package be.vergauwen.simon.cleanmvp.ui;

import be.vergauwen.simon.cleanmvp.mvp.MVPContract;

public interface MasterContract {
    interface View extends MVPContract.View {
        void showThings();
    }

    interface Presenter extends MVPContract.Presenter<View> {
        void loadThings();
    }
}