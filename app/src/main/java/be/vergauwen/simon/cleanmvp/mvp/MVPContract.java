package be.vergauwen.simon.cleanmvp.mvp;

public interface MVPContract {
    interface View {}

    interface Presenter<V extends View> {
        V getView();
        void attachView(V view);
        void detachView();
    }
}
