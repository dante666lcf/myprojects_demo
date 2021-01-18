package kz.alemtime.alem.mvp.pages.drawer_fragments.drawer_menu

import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter

@InjectViewState
class FragmentDrawerMenuPresenter(
        router: ApplicationRouter
) : AbstractPresenter<FragmentDrawerMenuContract.View>(router), FragmentDrawerMenuContract.Presenter {

    private val modelDrawerMenu: FragmentDrawerMenuContract.Model = FragmentDrawerMenuModel()

    init {

    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}