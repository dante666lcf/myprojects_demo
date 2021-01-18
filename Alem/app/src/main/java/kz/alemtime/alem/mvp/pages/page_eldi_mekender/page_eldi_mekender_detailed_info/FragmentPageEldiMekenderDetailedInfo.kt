package kz.alemtime.alem.mvp.pages.page_eldi_mekender.page_eldi_mekender_detailed_info

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kz.alemtime.alem.R
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.support.provider.FragmentProvider

class FragmentPageEldiMekenderDetailedInfo
    : RootMvpAppCompatFragment<FragmentPageEldiMekenderDetailedInfoPresenter>(), FragmentPageEldiMekenderDetailedInfoContract.View {

    companion object {
        fun newInstance(): FragmentPageEldiMekenderDetailedInfo {
            val fragment = FragmentPageEldiMekenderDetailedInfo()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentPageEldiMekenderDetailedInfoPresenter

    @ProvidePresenter
    internal fun provideFragmentPageEldiMekenderDetailedInfoPresenter(): FragmentPageEldiMekenderDetailedInfoPresenter {
        return FragmentPageEldiMekenderDetailedInfoPresenter(router)
    }

    override fun getPresenter(): FragmentPageEldiMekenderDetailedInfoPresenter {
        return mPresenter
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider().setLayoutResourceId(R.layout.fragment_page_eldimekender_detailed_info)
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroyView() {
        mPresenter.onDestroyView()
        super.onDestroyView()
    }

    override fun prepareUI() {

    }
}