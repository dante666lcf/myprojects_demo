package kz.app.bender.mvp.login

import com.arellomobile.mvp.InjectViewState
import kz.app.bender.mvp.AbstractPresenter
import kz.app.bender.support.navigation.BenderRouter
import kz.app.bender.support.navigation.Screens
import kz.app.bender.support.threads.withDefaultSchedulers

@InjectViewState
class LoginPresenter(router: BenderRouter)
    : AbstractPresenter<LoginContract.View>(router), LoginContract.Presenter {

    private val modelLogin: LoginContract.Model = LoginModel()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.hideButtonLogin()
        viewState.showButtonSendCode()
    }

    override fun postAuthUser(iin: String, code: String) {
        val subscriptionPostUserAuth = modelLogin.postAuth(iin, code)
                .withDefaultSchedulers()
                .subscribe({
                    modelLogin.setUserData(it)
                    router.newRootScreen(Screens.getChildrenList())
                }, {
//                    viewState.showRequestError(it)
                    viewState.showToast(it.message!!)
                })
        connectionSubscriptions.add(subscriptionPostUserAuth)
    }

    override fun postSendCode(iin: String) {
        val subscriptionPostSendCode = modelLogin.postSendCode(iin)
                .withDefaultSchedulers()
                .subscribe({
                    viewState.hideButtonSendCode()
                    viewState.showButtonLogin()
                    viewState.showToast("СМС код был выслан Вам на телефон")
                }, {
                    viewState.showRequestError(it)
                })
        connectionSubscriptions.add(subscriptionPostSendCode)
    }
}