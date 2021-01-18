package kz.app.deliveryapp.mvp.страницы.корзина

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListBasket

interface FragmentBasketContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun setAdapterListBasket(adapterListBasket: AdapterListBasket)
    }

    interface Presenter {
        fun getListBasket()
        fun setListBasketToPresenter()
    }
}