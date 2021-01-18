package kz.alemtime.alem.mvp.pages.page_eldi_mekender

import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter

@InjectViewState
class FragmentPageEldiMekenderPresenter(
        router: ApplicationRouter
) : AbstractPresenter<FragmentPageEldiMekenderContract.View>(router), FragmentPageEldiMekenderContract.Presenter {

    init {

    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun onDestroyView() {}
}