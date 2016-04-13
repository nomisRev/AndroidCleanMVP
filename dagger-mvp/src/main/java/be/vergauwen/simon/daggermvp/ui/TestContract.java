package be.vergauwen.simon.daggermvp.ui;

import be.vergauwen.simon.himura.MVPContract;

public interface TestContract {
    interface View extends MVPContract.View {
        void showThings();
    }

    interface Presenter extends MVPContract.Presenter<View> {
        void loadThings();
    }

    interface Component extends MVPContract.Component<Presenter> {}
}