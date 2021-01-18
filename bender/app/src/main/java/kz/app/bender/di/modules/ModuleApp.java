package kz.app.bender.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kz.app.bender.mvp.root.ActivityMain;
import kz.app.bender.support.stat.Zvars;

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
