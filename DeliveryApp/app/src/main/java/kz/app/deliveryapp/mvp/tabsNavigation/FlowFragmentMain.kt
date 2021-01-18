package kz.app.deliveryapp.mvp.tabsNavigation

import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.Gravity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_navigation_drawer.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.основнойКонтейнер.RootPresenter
import kz.app.deliveryapp.support.навигация.BenderRouter
import kz.app.deliveryapp.support.навигация.RouterProvider
import kz.app.deliveryapp.support.навигация.Screens
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class FlowFragmentMain : RootMvpAppCompatFragment<FlowFragmentMainPresenter>(), RouterProvider,
    FlowFragmentContract.View {

    //region Vars
    private var tabsRouter: Cicerone<BenderRouter>? = null
    private var tabsNavigator: Navigator? = null
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: FlowFragmentMainPresenter

    @ProvidePresenter
    internal fun createFlowFragmentMainPresenter(): FlowFragmentMainPresenter {
        createTabsRouterIfNecessary()
        return FlowFragmentMainPresenter(router, tabsRouter!!.router)
    }
    //endregion

    //region Overridden methods
    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider().setLayoutResourceId(R.layout.fragment_navigation_drawer)
            .setToolbarTitle(getString(R.string.text_menu), R.color.colorAccent)
            .setToolbarHamburgerColor(R.color.colorAccent)
    }

    override fun getPresenter(): FlowFragmentMainPresenter {
        return mPresenter
    }

    override fun provideRouter(): BenderRouter {
        return tabsRouter!!.router
    }

    override fun onResume() {
        createTabsRouterIfNecessary()
        super.onResume()
        mPresenter.setTabsRouter(tabsRouter!!.router)
    }

    override fun onPause() {
        tabsRouter!!.navigatorHolder.removeNavigator()
        super.onPause()
    }
    //endregion

    //region UI
    override fun prepareUI() {
        if (fragmentProvider.toolbarHamburgerColor != null)
            toolbar?.setNavigationOnClickListener { drawer_layout.openDrawer(Gravity.START) }

        navigation.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_menu_menu -> {
                    toolbar?.setTitle(R.string.text_menu)
                    mPresenter.onNavTabClicked(Screens.Tabs.nav_tab_menu)
                }
                R.id.nav_menu_basket -> {
                    RootPresenter.instance.flowNavigateTo(Screens.getBasketList())
                }
                R.id.nav_menu_aksiya -> {
                    toolbar?.setTitle(R.string.text_aksiya)
                    mPresenter.onNavTabClicked(Screens.Tabs.nav_tab_aksii)
                }
                R.id.nav_menu_news -> {
                    toolbar?.setTitle(R.string.text_news)
                    mPresenter.onNavTabClicked(Screens.Tabs.nav_tab_news)
                }
                else -> return@OnNavigationItemSelectedListener true
            }
            drawer_layout.closeDrawer(Gravity.START)
            true
        })
    }
    //endregion

    //region Support
    private fun createTabsRouterIfNecessary() {
        if (tabsRouter == null)
            tabsRouter = Cicerone.create(BenderRouter())

        if (tabsNavigator == null)
            tabsNavigator = object : SupportAppNavigator(activity, childFragmentManager, R.id.flFragmentFrameDrawer) {
                override fun setupFragmentTransaction(
                    command: Command?,
                    currentFragment: Fragment?,
                    nextFragment: Fragment?,
                    fragmentTransaction: FragmentTransaction?
                ) {
                    fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                }
            }
        tabsRouter!!.navigatorHolder.setNavigator(tabsNavigator)
    }

    companion object {
        fun newInstance(): FlowFragmentMain {
            return FlowFragmentMain()
        }
    }
}
