package be.vergauwen.simon.cleanmvp.mvp;

import java.lang.ref.WeakReference;

/**
 * @author janvancoppenolle
 */
public abstract class MVPPresenter<V extends MVPContract.View>
        implements MVPContract.Presenter<V> {
    private WeakReference<V> viewRef;

    @Override
    public V view() {
        return viewRef == null ? null : viewRef.get();
    }

    @Override
    public void attach(V view) {
        viewRef = new WeakReference<>(view);
    }

    @Override
    public void destroy() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
