package kz.app.bender.di;

import javax.inject.Inject;

import kz.app.bender.ApplicationMain;
import kz.app.bender.mvp.root.ActivityMain;

public class DIWrapper {

    @Inject
    public ActivityMain activity;

    public DIWrapper() {
        ApplicationMain.instance.getComponentNet().inject(this);
    }
}
