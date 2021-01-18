package kz.alemtime.alem.mvp.flow.signUp

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.models.TResponseResultAuthRegistration
import kz.alemtime.alem.mvp.AbstractView
import rx.Single

interface SignUpFragmentContract {

    interface Model {
        fun postAuthRegistration(username: String, email: String, password: String): Single<TResponseResultAuthRegistration>
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun showToast(text: String)
    }

    interface Presenter {
        fun postAuthRegistration(username: String, email: String, password: String)
    }
}