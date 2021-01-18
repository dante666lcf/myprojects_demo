package kz.alemtime.alem.mvp.flow.signUp

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.flow_fragment_signup.*
import kz.alemtime.alem.R
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.support.provider.FragmentProvider
import kz.alemtime.alem.support.stat.ZUtils

class SignUpFragment : RootMvpAppCompatFragment<SignUpFragmentPresenter>(), SignUpFragmentContract.View {

    override fun getPresenter(): SignUpFragmentPresenter {
        return mPresenter
    }

    companion object {
        fun newInstance(): SignUpFragment {
            val args = Bundle()
            val fragment = SignUpFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: SignUpFragmentPresenter

    @ProvidePresenter
    internal fun createSignUpFragmentPresenter(): SignUpFragmentPresenter {
        return SignUpFragmentPresenter(router)
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setLayoutResourceId(R.layout.flow_fragment_signup)
    }

    override fun prepareUI() {
        fragment_signup_mbtn_signup.setOnClickListener {
            if (fragment_signup_et_fullname.text.toString().length > 1) {
                if (fragment_signup_et_email.text.toString().length > 1) {
                    if (fragment_signup_et_password.text.toString().length > 1) {
                        mPresenter.postAuthRegistration(
                                fragment_signup_et_fullname.text.toString(),
                                fragment_signup_et_email.text.toString(),
                                fragment_signup_et_password.text.toString())
                    } else {
                        ZUtils.showToastSimple(context, "Поле 'password' не заполнено.")
                    }
                } else {
                    ZUtils.showToastSimple(context, "Поле 'email' не заполнено.")
                }
            } else {
                ZUtils.showToastSimple(context, "Поле 'username' не заполнено.")
            }
        }
    }

    override fun showToast(text: String) {
        ZUtils.showToastSimple(context, text)
    }
}