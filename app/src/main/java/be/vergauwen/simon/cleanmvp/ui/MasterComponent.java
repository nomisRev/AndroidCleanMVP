package be.vergauwen.simon.cleanmvp.ui;

import be.vergauwen.simon.cleanmvp.di.ActivityScope;
import be.vergauwen.simon.cleanmvp.di.ApplicationComponent;
import be.vergauwen.simon.cleanmvp.mvp.MVPContract;
import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class)
public interface MasterComponent extends MVPContract.Component<MasterPresenter> {
    MasterPresenter presenter();
}
