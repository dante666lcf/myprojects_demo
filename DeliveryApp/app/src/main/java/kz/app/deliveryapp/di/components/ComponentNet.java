package kz.app.deliveryapp.di.components;

import dagger.Component;
import kz.app.deliveryapp.ApplicationMain;
import kz.app.deliveryapp.di.DIWrapper;
import kz.app.deliveryapp.di.modules.ModuleApp;
import kz.app.deliveryapp.mvp.AbstractModel;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ModuleApp.class})
public interface ComponentNet {
    void inject(ApplicationMain application);

    void inject(DIWrapper diWrapper);

    void inject(AbstractModel abstractModel);
}
