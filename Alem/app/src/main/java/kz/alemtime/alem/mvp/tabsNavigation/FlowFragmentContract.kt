package kz.alemtime.alem.mvp.tabsNavigation

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.mvp.AbstractView

interface FlowFragmentContract {

    interface Model

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView

    interface Presenter
}