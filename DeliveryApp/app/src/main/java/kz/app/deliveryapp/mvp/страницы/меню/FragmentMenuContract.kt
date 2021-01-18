package kz.app.deliveryapp.mvp.страницы.меню

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListDefault1
import kz.app.deliveryapp.mvp.модели.модель_меню.TMenuList

interface FragmentMenuContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun setAdapterListMenu(adapterListMenu: AdapterListDefault1)
    }

    interface Presenter {
        fun getListMenu()
        fun setListMenuToPresenter(menuList: ArrayList<TMenuList>)
    }
}