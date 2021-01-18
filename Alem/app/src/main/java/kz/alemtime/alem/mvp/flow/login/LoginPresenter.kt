package kz.alemtime.alem.mvp.flow.login

import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.models.TProfile
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.mvp.main.MainPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter
import kz.alemtime.alem.support.navigation.Screens
import kz.alemtime.alem.support.stat.ZPrefs
import kz.alemtime.alem.support.threads.withDefaultSchedulers

@InjectViewState
class LoginPresenter(router: ApplicationRouter)
    : AbstractPresenter<LoginContract.View>(router), LoginContract.Presenter {

    private val modelLogin: LoginContract.Model = LoginModel()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun postAuth(email: String, password: String) {
        val subscriptionPostAuth = modelLogin.postAuth(email, password)
                .withDefaultSchedulers()
                .subscribe({
                    if (it != null) {
                        if (it.status) {
                            ZPrefs.setUserAuthToken(it.access_token)
                            val profile = TProfile()
                            profile.email = it.email
                            profile.access_token_expires = it.access_token_expires
                            profile.user_id = it.user_id
                            profile.full_name = it.full_name
                            ZPrefs.setUserProfile(profile, model.sharedPreferences)
                            MainPresenter.instance.flowRouter.newRootScreen(Screens.getFlowTabsNavigation())
                        }
                    }
                }, {
                    /*TODO: сделать loader*/
                    viewState.showRequestError(it)
                })
        connectionSubscriptions.add(subscriptionPostAuth)
    }
}
