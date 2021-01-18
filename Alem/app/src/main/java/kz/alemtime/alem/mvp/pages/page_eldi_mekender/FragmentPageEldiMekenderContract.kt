package kz.alemtime.alem.mvp.pages.page_eldi_mekender

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.mvp.AbstractView

interface FragmentPageEldiMekenderContract {

    interface Model {

    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {

    }

    interface Presenter {

    }
}