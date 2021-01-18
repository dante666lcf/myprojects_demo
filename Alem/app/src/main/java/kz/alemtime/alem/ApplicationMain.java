package kz.alemtime.alem;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import com.orhanobut.hawk.Hawk;

import kz.alemtime.alem.di.components.ComponentNet;
import kz.alemtime.alem.di.components.DaggerComponentNet;
import kz.alemtime.alem.di.modules.ModuleApp;
import kz.alemtime.alem.di.modules.ModuleNet;

public class ApplicationMain extends MultiDexApplication {

    public static ApplicationMain instance;

    private ComponentNet componentNet;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        componentNet = DaggerComponentNet.builder()
                .moduleApp(new ModuleApp(this))
                .moduleNet(new ModuleNet(this))
                .build();
        componentNet.inject(this);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        Hawk.init(this).build();
    }

    public ComponentNet getComponentNet() {
        return componentNet;
    }

//    fun getLogout() {
//        if (Zprefs.getUserAuthToken() != null) {
//            SubscriptionBuilder(gatewayApi.deleteFirebaseToken())
//                    .doOnNext({ response ->
//                        SubscriptionBuilder(gatewayApi.getLogout())
//                                .doOnNext({ tResponseResultResponse ->
//                                    if (tResponseResultResponse.code() === 200) {
//                                        Zprefs.logOut(sharedPreferences)
//                                    }
//                                })
//                                .observeOnNewThread()
//                                .build()
//                        Log.e("logout", "on next")
//                    })
//                    .doOnCompleted({ Log.e("logout", "on completed") })
//                    .observeOnNewThread()
//                    .build()
//        }
}
