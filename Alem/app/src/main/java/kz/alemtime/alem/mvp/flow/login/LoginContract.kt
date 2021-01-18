package kz.alemtime.alem.mvp.flow.login

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.models.TResponseResultAuth
import kz.alemtime.alem.mvp.AbstractView
import rx.Single

interface LoginContract {

    interface Model {
        fun postAuth(email: String, password: String): Single<TResponseResultAuth>
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {

    }

    interface Presenter {
        fun postAuth(email: String, password: String)
    }
}