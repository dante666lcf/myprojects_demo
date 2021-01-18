package ru.tusur.study.mobile.mvp.fragments.login

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.tusur.study.mobile.mvp.abstracts.AbstractContract

interface LoginContract {

    @StateStrategyType(OneExecutionStateStrategy::class)
    interface View : AbstractContract.View {

    }

    interface Presenter : AbstractContract.Presenter {

    }

}