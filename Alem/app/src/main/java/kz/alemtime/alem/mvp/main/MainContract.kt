package kz.alemtime.alem.mvp.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.mvp.AbstractView

interface MainContract {

    interface Model

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView

    interface Presenter

}