package ru.tusur.study.mobile.mvp.fragments.login

import moxy.presenter.InjectPresenter
import ru.tusur.study.mobile.R
import ru.tusur.study.mobile.mvp.abstracts.AbstractFragment

class LoginFragment : AbstractFragment<LoginPresenter>(), LoginContract.View {

    @InjectPresenter
    internal lateinit var presenter: LoginPresenter

    override fun getLayoutResourceId(): Int = R.layout.fragment_login

    override fun getPresenter(): LoginPresenter = presenter

    override fun prepareUI() {

    }

}