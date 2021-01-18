package kz.app.bender;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import com.orhanobut.hawk.Hawk;

import io.realm.Realm;
import kz.app.bender.di.components.ComponentNet;
import kz.app.bender.di.modules.ModuleApp;

public class ApplicationMain extends MultiDexApplication {

    //region Static
    public static ApplicationMain instance;
    //endregion

    //region Vars
    private kz.app.bender.di.components.ComponentNet componentNet;
    //endregion

    //region Overridden methods
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Realm.init(instance);

        //region Dagger
        componentNet = DaggerComponentNet.builder()
                .moduleApp(new ModuleApp(this))
                .moduleNet(new ModuleNet(this))
                .build();
        componentNet.inject(this);
        //endregion

        //region Vector drawable compatibility
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        //endregion

        //region Hawk
        Hawk.init(this).build();
        //endregion
    }
    //endregion

    //region Getters
    public ComponentNet getComponentNet() {
        return componentNet;
    }
    //endregion
}
