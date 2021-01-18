package kz.app.deliveryapp.mvp.страницы.детальная_информация_еды

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem

interface FragmentDetailedInfoContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun setInfo(edaItem: TEdaItem)
    }

    interface Presenter {

    }

}