package ru.tusur.study.mobile.mvp.activity

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.tusur.study.mobile.mvp.abstracts.AbstractContract

interface RootContract {


    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractContract.View {

    }

    interface Presenter : AbstractContract.Presenter {
        fun logout()

        fun onResumeViewState()

        fun onPauseViewState()
    }
}