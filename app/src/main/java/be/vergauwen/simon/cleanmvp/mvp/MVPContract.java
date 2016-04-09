package be.vergauwen.simon.cleanmvp.mvp;

/**
 * @author janvancoppenolle
 */
public interface MVPContract {
    interface View<P extends Presenter> {
        P presenter();
    }

    interface Presenter<V extends View> {
        V view();
        void attach(V view);
        void destroy();
    }
}
