package kz.app.bender.mvp.login

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.AbstractView
import rx.Single

interface LoginContract {

    interface Model {
        fun postAuth(iin: String, code: String): Single<TSignIn>

        fun postSendCode(iin: String): Single<Any?>

        fun setUserData(signIn: TSignIn)

        fun getUserData(): TSignIn?
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun showButtonLogin()

        fun hideButtonLogin()

        fun showButtonSendCode()

        fun hideButtonSendCode()

        fun showToast(toast: String)
    }

    interface Presenter {
        fun postAuthUser(iin: String, code: String)

        fun postSendCode(iin: String)
    }
}