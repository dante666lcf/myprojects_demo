package kz.alemtime.alem.mvp.pages.page_alem_time.page_alem_time_detailed_info

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.mvp.AbstractView

interface FragmentPageAlemTimeDetailedInfoContract {

    interface Model {

    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {

    }

    interface Presenter {

    }
}