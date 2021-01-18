package ru.tusur.study.mobile.di.components

import dagger.Component
import org.jetbrains.annotations.NotNull
import ru.tusur.study.mobile.ApplicationMain
import ru.tusur.study.mobile.mvp.activity.RootPresenter
import ru.tusur.study.mobile.mvp.fragments.login.LoginPresenter
import ru.tusur.study.mobile.mvp.fragments.main_menu.MainMenuPresenter
import javax.inject.Singleton

@Singleton
@Component
interface ComponentDI {

    fun inject(@NotNull applicationMain: ApplicationMain)

    fun inject(@NotNull rootPresenter: RootPresenter)

    fun inject(@NotNull loginPresenter: LoginPresenter)

    fun inject(@NotNull mainMenuPresenter: MainMenuPresenter)
}