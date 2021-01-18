package ru.tusur.study.mobile.mvp.fragments.login

import moxy.InjectViewState
import ru.tusur.study.mobile.ApplicationMain
import ru.tusur.study.mobile.mvp.abstracts.AbstractPresenter

@InjectViewState
class LoginPresenter : AbstractPresenter<LoginContract.View>(), LoginContract.Presenter {

    init {
        ApplicationMain.componentDI.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}