package kz.app.deliveryapp.mvp.страницы.меню_раздел

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListMenuRazdel
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem

interface FragmentMenuRazdelContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun setAdapterListMenuRazdel(adapterListMenuRazdel: AdapterListMenuRazdel)
        fun addToBasket(edaItem: TEdaItem)
        fun addToFavorites(edaItem: TEdaItem)
    }

    interface Presenter {
        fun getListMenuRazdel()
        fun setListMenuRazdelToPresenter(edaList: ArrayList<TEdaItem>)
    }
}