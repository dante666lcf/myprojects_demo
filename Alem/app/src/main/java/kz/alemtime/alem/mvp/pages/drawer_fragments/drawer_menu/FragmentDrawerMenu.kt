package kz.alemtime.alem.mvp.pages.drawer_fragments.drawer_menu

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kz.alemtime.alem.R
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.support.provider.FragmentProvider

class FragmentDrawerMenu
    : RootMvpAppCompatFragment<FragmentDrawerMenuPresenter>(), FragmentDrawerMenuContract.View {

    companion object {
        fun newInstance(): FragmentDrawerMenu {
            val fragment = FragmentDrawerMenu()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentDrawerMenuPresenter

    @ProvidePresenter
    internal fun provideFragmentDrawerMenuPresenter(): FragmentDrawerMenuPresenter {
        return FragmentDrawerMenuPresenter(router)
    }

    override fun getPresenter(): FragmentDrawerMenuPresenter {
        return mPresenter
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider().setLayoutResourceId(R.layout.drawer_menu_fragment)
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