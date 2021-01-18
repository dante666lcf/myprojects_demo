package kz.alemtime.alem.mvp.flow.signUp

import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter
import kz.alemtime.alem.support.threads.withDefaultSchedulers

@InjectViewState
class SignUpFragmentPresenter(router: ApplicationRouter)
    : AbstractPresenter<SignUpFragmentContract.View>(router), SignUpFragmentContract.Presenter {

    private val modelSignUp: SignUpFragmentContract.Model = SignUpFragmentModel()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun postAuthRegistration(username: String, email: String, password: String) {
        val subscriptionPostAuthRegistration = modelSignUp.postAuthRegistration(username, email, password)
                .withDefaultSchedulers()
                .subscribe({
                    if (it != null)
                        if (it.status)
                            viewState.showToast(it.message!!)

                }, {
                    /*TODO: сделать loader*/
                    viewState.showRequestError(it)
                })
        connectionSubscriptions.add(subscriptionPostAuthRegistration)
    }
}