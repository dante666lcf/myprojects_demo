package ru.tusur.study.mobile.mvp.abstracts

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.tusur.study.mobile.mvp.abstracts.view.interfaces.ErrorInformativeView

interface AbstractContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : MvpView, ErrorInformativeView {
        fun prepareUI()

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun showLoading()

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun hideLoading()

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun showInfo(title: String?, message: String?)

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun showSuccess(title: String?, message: String?)

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun showWarning(title: String?, message: String?)

//        @StateStrategyType(OneExecutionStateStrategy::class)
//        fun showNotification(type: RegularBanner.Type, title: String, description: String, duration: RegularBanner.Duration)

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun exit()

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun restartActivity()

        @StateStrategyType(OneExecutionStateStrategy::class)
        fun onLogout()
    }

    interface Presenter
}