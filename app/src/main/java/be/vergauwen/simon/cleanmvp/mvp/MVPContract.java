package be.vergauwen.simon.cleanmvp.mvp;

/**
 * @author janvancoppenolle
 */
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
