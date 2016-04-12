package be.vergauwen.simon.himura;

import java.lang.ref.WeakReference;

public abstract class MVPPresenter<V extends MVPContract.View> implements MVPContract.Presenter<V> {
    private WeakReference<V> viewRef;

    @Override
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}