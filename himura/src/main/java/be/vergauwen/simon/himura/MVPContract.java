package be.vergauwen.simon.himura;

public interface MVPContract {
    interface View {}

    interface Presenter<V extends View> {
        V getView();
        void attachView(V view);
        void detachView();
    }

    interface Component<P extends Presenter> {
        P presenter();
    }
}