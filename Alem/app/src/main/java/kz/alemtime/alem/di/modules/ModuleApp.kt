package kz.alemtime.alem.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import kz.alemtime.alem.mvp.main.MainActivity
import kz.alemtime.alem.support.stat.ZVars
import javax.inject.Singleton

@Module
class ModuleApp(private var application: Application) {

    fun ModuleApp(application: Application) {
        this.application = application
    }

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return this.application
    }

    @Provides
    @Singleton
    internal fun providesActivityMain(): MainActivity {
        return MainActivity.instance
    }

    @Provides
    @Singleton
    internal fun providesSharedPreferences(): SharedPreferences {
        return application.getSharedPreferences(ZVars.ALEM_PRIVATE_PREFERENCES, Context.MODE_PRIVATE)
    }

}