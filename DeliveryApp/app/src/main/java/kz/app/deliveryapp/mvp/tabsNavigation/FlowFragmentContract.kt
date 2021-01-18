package kz.app.deliveryapp.mvp.tabsNavigation

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView

interface FlowFragmentContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView

    interface Presenter
}