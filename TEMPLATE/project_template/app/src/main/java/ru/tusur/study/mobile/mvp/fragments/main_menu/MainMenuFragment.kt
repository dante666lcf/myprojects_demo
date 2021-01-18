package ru.tusur.study.mobile.mvp.fragments.main_menu

import moxy.presenter.InjectPresenter
import ru.tusur.study.mobile.R
import ru.tusur.study.mobile.mvp.abstracts.AbstractFragment

class MainMenuFragment : AbstractFragment<MainMenuPresenter>(), MainMenuContract.View {

    @InjectPresenter
    internal lateinit var presenter: MainMenuPresenter

    override fun getLayoutResourceId(): Int = R.layout.fragment_main_menu

    override fun getPresenter(): MainMenuPresenter = presenter

    override fun prepareUI() {

    }

}