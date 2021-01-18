package kz.app.deliveryapp.mvp.страницы.акции

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListAksii
import kz.app.deliveryapp.mvp.модели.модель_акции.THotItem

interface FragmentAksiiContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun setAdapterListAksii(adapterListAksii: AdapterListAksii)
    }

    interface Presenter {
        fun getListAksii()
        fun setListAksiiToPresenter(hotItem: ArrayList<THotItem>)
    }

}