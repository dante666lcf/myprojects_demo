package kz.alemtime.alem.mvp.pages.page_alem_time.page_alem_time_detailed_info

import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter

@InjectViewState
class FragmentPageAlemTimeDetailedInfoPresenter(
        router: ApplicationRouter
) : AbstractPresenter<FragmentPageAlemTimeDetailedInfoContract.View>(router), FragmentPageAlemTimeDetailedInfoContract.Presenter {

    private val modelAlemTimeDetailedInfo: FragmentPageAlemTimeDetailedInfoContract.Model = FragmentPageAlemTimeDetailedInfoModel()

    init {

    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}