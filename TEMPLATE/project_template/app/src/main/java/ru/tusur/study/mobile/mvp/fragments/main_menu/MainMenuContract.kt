package ru.tusur.study.mobile.mvp.fragments.main_menu

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.tusur.study.mobile.mvp.abstracts.AbstractContract

interface MainMenuContract {

    @StateStrategyType(OneExecutionStateStrategy::class)
    interface View : AbstractContract.View {

    }

    interface Presenter : AbstractContract.Presenter {

    }

}