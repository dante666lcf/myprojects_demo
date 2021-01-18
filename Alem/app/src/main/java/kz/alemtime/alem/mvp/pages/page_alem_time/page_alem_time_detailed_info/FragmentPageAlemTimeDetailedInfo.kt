package kz.alemtime.alem.mvp.pages.page_alem_time.page_alem_time_detailed_info

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kz.alemtime.alem.R
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.support.provider.FragmentProvider

class FragmentPageAlemTimeDetailedInfo
    : RootMvpAppCompatFragment<FragmentPageAlemTimeDetailedInfoPresenter>(), FragmentPageAlemTimeDetailedInfoContract.View {

    companion object {
        fun newInstance(): FragmentPageAlemTimeDetailedInfo {
            val fragment = FragmentPageAlemTimeDetailedInfo()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentPageAlemTimeDetailedInfoPresenter

    @ProvidePresenter
    internal fun provideFragmentPageAlemTimeDetailedInfoPresenter(): FragmentPageAlemTimeDetailedInfoPresenter {
        return FragmentPageAlemTimeDetailedInfoPresenter(router)
    }

    override fun getPresenter(): FragmentPageAlemTimeDetailedInfoPresenter {
        return mPresenter
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider().setLayoutResourceId(R.layout.fragment_page_alemtime_detailed_info)
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