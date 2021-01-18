package kz.app.deliveryapp.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import kz.app.deliveryapp.mvp.основнойКонтейнер.ActivityMain;
import kz.app.deliveryapp.support.stat.Zvars;

import javax.inject.Singleton;

@Module
public class ModuleApp {

    private final Application application;

    public ModuleApp(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return this.application;
    }

    @Provides
    ActivityMain providesActivityMain() {
        return ActivityMain.instance;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences() {
        return application.getSharedPreferences(Zvars.INDIGO_PRIVATE_PREFERENCES, Context.MODE_PRIVATE);
    }
}
