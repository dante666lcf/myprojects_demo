package ru.tusur.study.mobile.mvp.fragments.main_menu

import moxy.InjectViewState
import ru.tusur.study.mobile.ApplicationMain
import ru.tusur.study.mobile.mvp.abstracts.AbstractPresenter

@InjectViewState
class MainMenuPresenter : AbstractPresenter<MainMenuContract.View>(), MainMenuContract.Presenter {

    init {
        ApplicationMain.componentDI.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}