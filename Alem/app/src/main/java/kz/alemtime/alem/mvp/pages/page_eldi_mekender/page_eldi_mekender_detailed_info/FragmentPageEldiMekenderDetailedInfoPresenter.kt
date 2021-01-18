package kz.alemtime.alem.mvp.pages.page_eldi_mekender.page_eldi_mekender_detailed_info

import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter

@InjectViewState
class FragmentPageEldiMekenderDetailedInfoPresenter(
        router: ApplicationRouter
) : AbstractPresenter<FragmentPageEldiMekenderDetailedInfoContract.View>(router), FragmentPageEldiMekenderDetailedInfoContract.Presenter {

    private val modelEldiMekenderDetailedInfo: FragmentPageEldiMekenderDetailedInfoContract.Model = FragmentPageEldiMekenderDetailedInfoModel()

    init {

    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}