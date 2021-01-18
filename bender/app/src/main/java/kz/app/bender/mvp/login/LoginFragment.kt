package kz.app.bender.mvp.login

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_login.*
import kz.app.bender.R
import kz.app.bender.mvp.IndigoMVPFragment
import kz.app.bender.support.provider.FragmentProvider
import kz.app.bender.support.stat.Zutils

class LoginFragment : IndigoMVPFragment<LoginPresenter>(), LoginContract.View {

    //region Companion
    companion object {
        fun newInstance(): LoginFragment {
            val fragment = LoginFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: LoginPresenter

    @ProvidePresenter
    internal fun providesLoginPresenter(): LoginPresenter {
        return LoginPresenter(router)
    }

    override fun getPresenter(): LoginPresenter {
        return mPresenter
    }
    //endregion

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setToolbarTitle(getString(R.string.login))
                .setLayoutResourceId(R.layout.fragment_login)
    }

    override fun prepareUI() {
        mBtnLoginEnter.setOnClickListener {
            if (edEnterIIN.text.length == 12) {
                if (edEnterSmsCode.text.length == 4) {
                    mPresenter.postAuthUser(edEnterIIN.text.toString(), edEnterSmsCode.text.toString())
                } else {
                    Zutils.showToastSimple(activity, getString(R.string.enter_sms_code_for_login))
                }
            } else {
                Zutils.showToastSimple(activity, getString(R.string.enter_your_iin))
            }
        }

        mBtnSendCode.setOnClickListener {
            if (edEnterIIN.text.length == 12) {
                mPresenter.postSendCode(edEnterIIN.text.toString())
            } else {
                Zutils.showToastSimple(activity, getString(R.string.enter_your_iin))
            }
        }
    }

    override fun showButtonLogin() {
        mBtnLoginEnter.visibility = View.VISIBLE
    }

    override fun hideButtonLogin() {
        mBtnLoginEnter.visibility = View.GONE
    }

    override fun showButtonSendCode() {
        mBtnSendCode.visibility = View.VISIBLE
    }

    override fun hideButtonSendCode() {
        mBtnSendCode.visibility = View.GONE
    }

    override fun showToast(toast: String) {
        Zutils.showToastSimple(activity, toast)
    }
}