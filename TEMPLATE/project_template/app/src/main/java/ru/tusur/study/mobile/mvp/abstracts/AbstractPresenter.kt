package ru.tusur.study.mobile.mvp.abstracts

import androidx.annotation.CallSuper
import moxy.MvpPresenter

abstract class AbstractPresenter<T : AbstractContract.View> : MvpPresenter<T>(), AbstractContract.Presenter {

    //region Vars
//    protected val taskHandler = TaskHandler()
//    protected val throwableHandler = UIThrowableHandler(viewState)
    //endregion

    //region Overridden methods
    @CallSuper
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.prepareUI()
    }

    override fun onDestroy() {
//        taskHandler.cancelAll()
        super.onDestroy()
    }
    //endregion
}