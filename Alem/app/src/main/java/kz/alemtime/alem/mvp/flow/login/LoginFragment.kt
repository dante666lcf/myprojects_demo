package kz.alemtime.alem.mvp.flow.login

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.flow_fragment_login.*
import kz.alemtime.alem.R
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.mvp.main.MainPresenter
import kz.alemtime.alem.support.navigation.Screens
import kz.alemtime.alem.support.provider.FragmentProvider
import kz.alemtime.alem.support.stat.ZUtils

class LoginFragment : RootMvpAppCompatFragment<LoginPresenter>(), LoginContract.View {

    companion object {
        fun newInstance(): LoginFragment {
            val args = Bundle()
            val fragment = LoginFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: LoginPresenter

    @ProvidePresenter
    internal fun createLoginFragmentPresenter(): LoginPresenter {
        return LoginPresenter(router)
    }

    override fun getPresenter(): LoginPresenter {
        return mPresenter
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setLayoutResourceId(R.layout.flow_fragment_login)
    }

    override fun prepareUI() {
        fragment_login_mbtn_login.setOnClickListener {
            if (fragment_login_et_username.text.toString().length > 1) {
                if (fragment_login_et_password.text.toString().length > 1) {
                    mPresenter.postAuth(
                            fragment_login_et_username.text.toString(),
                            fragment_login_et_password.text.toString()
                    )
                } else {
                    ZUtils.showToastSimple(activity, "Поле 'passsword' не заполнено.")
                }
            } else {
                ZUtils.showToastSimple(activity, "Поле 'username' не заполнено.")
            }
        }

        fragment_login_tv_signup.setOnClickListener {
            MainPresenter.instance.flowNavigateTo(Screens.getFlowSignUp())
        }
    }
}
