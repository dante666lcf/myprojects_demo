package kz.alemtime.alem.mvp.pages.page_eldi_mekender

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kz.alemtime.alem.R
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.support.provider.FragmentProvider

class FragmentPageEldiMekender
    : RootMvpAppCompatFragment<FragmentPageEldiMekenderPresenter>(), FragmentPageEldiMekenderContract.View {

    companion object {
        fun newInstance(): FragmentPageEldiMekender {
            val fragment = FragmentPageEldiMekender()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentPageEldiMekenderPresenter

    @ProvidePresenter
    internal fun provideFragmentPageEldiMekenderPresenter(): FragmentPageEldiMekenderPresenter {
        return FragmentPageEldiMekenderPresenter(router)
    }

    override fun getPresenter(): FragmentPageEldiMekenderPresenter {
        return mPresenter
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider().setLayoutResourceId(R.layout.fragment_page_eldimekender)
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