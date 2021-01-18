package ru.tusur.study.mobile.mvp.activity

import moxy.InjectViewState
import ru.tusur.study.mobile.ApplicationMain
import ru.tusur.study.mobile.mvp.abstracts.AbstractPresenter

@InjectViewState
class RootPresenter : AbstractPresenter<RootContract.View>(), RootContract.Presenter {

    init {
        ApplicationMain.componentDI.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    override fun logout() {

    }

    override fun onResumeViewState() {

    }

    override fun onPauseViewState() {

    }

}