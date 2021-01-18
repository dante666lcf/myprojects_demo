package kz.app.bender.mvp.listChildren

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.bender.controllers.adapters.AdapterListChildren
import kz.app.bender.models.TChildrenItem
import kz.app.bender.mvp.AbstractView
import rx.Single

interface ChildrenContract {

    interface Model {
        fun getMyChildren(): Single<ArrayList<TChildrenItem>>
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun setChildrenList(adapterListChildrens: AdapterListChildren, spanCount: Int)

        fun changeFIOinItemMenu(fio: String?)
    }

    interface Presenter {
        fun getChildrenList()
    }
}