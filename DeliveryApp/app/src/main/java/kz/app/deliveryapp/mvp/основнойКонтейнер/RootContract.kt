package kz.app.deliveryapp.mvp.основнойКонтейнер

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView

interface RootContract {

    interface Model

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView

    interface Presenter

}