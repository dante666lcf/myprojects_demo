package kz.app.bender.mvp.tabsNavigation

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.AbstractView

interface FlowFragmentContract {

    interface Model {
        fun getUserData(): TSignIn?
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView

    interface Presenter
}