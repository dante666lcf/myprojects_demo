package kz.alemtime.alem.mvp.pages.drawer_fragments.drawer_menu

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.mvp.AbstractView

interface FragmentDrawerMenuContract {

    interface Model {

    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {

    }

    interface Presenter {

    }
}
