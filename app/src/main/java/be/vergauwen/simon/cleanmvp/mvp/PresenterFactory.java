package be.vergauwen.simon.cleanmvp.mvp;

public interface PresenterFactory<P extends MVPContract.Presenter> {
    P createPresenter();
}