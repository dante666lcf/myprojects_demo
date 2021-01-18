package kz.alemtime.alem.di.components

import dagger.Component
import kz.alemtime.alem.ApplicationMain
import kz.alemtime.alem.di.DIWrapper
import kz.alemtime.alem.di.modules.ModuleApp
import kz.alemtime.alem.di.modules.ModuleNet
import kz.alemtime.alem.mvp.AbstractModel
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleApp::class, ModuleNet::class])
interface ComponentNet {
    fun inject(application: ApplicationMain)

    fun inject(diWrapper: DIWrapper)

    fun inject(abstractModel: AbstractModel)
}