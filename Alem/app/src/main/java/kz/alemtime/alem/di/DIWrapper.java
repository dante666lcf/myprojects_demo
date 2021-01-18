package kz.alemtime.alem.di;

import javax.inject.Inject;

import kz.alemtime.alem.ApplicationMain;
import kz.alemtime.alem.mvp.main.MainActivity;

public class DIWrapper {

    @Inject
    public MainActivity activity;

    public DIWrapper() {
        ApplicationMain.instance.getComponentNet().inject(this);
    }
}
