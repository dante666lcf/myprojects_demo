package kz.app.bender.di.components;

import javax.inject.Singleton;

import dagger.Component;
import kz.app.bender.ApplicationMain;
import kz.app.bender.di.DIWrapper;
import kz.app.bender.di.modules.ModuleApp;
import kz.app.bender.mvp.AbstractModel;

@Singleton
@Component(modules = {ModuleApp.class, ModuleNet.class})
public interface ComponentNet {
    void inject(ApplicationMain application);

    void inject(DIWrapper diWrapper);

    void inject(AbstractModel abstractModel);
}
