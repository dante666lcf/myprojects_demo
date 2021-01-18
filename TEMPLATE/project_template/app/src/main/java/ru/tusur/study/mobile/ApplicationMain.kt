package ru.tusur.study.mobile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import ru.tusur.study.mobile.di.components.ComponentDI
import ru.tusur.study.mobile.di.components.DaggerComponentDI

class ApplicationMain : MultiDexApplication() {

    //region Companion
    companion object {
        internal lateinit var componentDI: ComponentDI
    }
    //endregion

    //region Overridden methods
    @SuppressLint("HardwareIds")
    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

//        DataLayer.init(
//            this,
//            Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID),
//            DeviceName.getDeviceName()
//        )

        componentDI = DaggerComponentDI.builder()
            .build()
        componentDI.inject(this)

    }
    //endregion
}