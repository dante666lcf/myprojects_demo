package kz.app.deliveryapp.di;

import kz.app.deliveryapp.ApplicationMain;
import kz.app.deliveryapp.mvp.основнойКонтейнер.ActivityMain;

import javax.inject.Inject;

public class DIWrapper {

    @Inject
    public ActivityMain activity;

    public DIWrapper() {
        ApplicationMain.instance.getComponentNet().inject(this);
    }
}
