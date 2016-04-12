package be.vergauwen.simon.cleanmvp.ui;

import be.vergauwen.simon.himura.MVPContract;

interface TestContract {
    interface View extends MVPContract.View {
        void showThings();
    }

    interface Presenter extends MVPContract.Presenter<View> {
        void loadThings();
    }
}