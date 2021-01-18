package kz.alemtime.alem.mvp.tabsNavigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.Gravity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_navigation_drawer.*
import kz.alemtime.alem.R
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.support.navigation.ApplicationRouter
import kz.alemtime.alem.support.navigation.RouterProvider
import kz.alemtime.alem.support.provider.FragmentProvider
import kz.alemtime.alem.support.stat.ZUtils
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command

class FlowFragmentMain : RootMvpAppCompatFragment<FlowFragmentMainPresenter>(), RouterProvider,
        FlowFragmentContract.View {

    //region Vars
    private var tabsRouter: Cicerone<ApplicationRouter>? = null
    private var tabTopNavRouter: Cicerone<ApplicationRouter>? = null
    private var tabsNavigator: Navigator? = null
    private var tabTopNavNavigator: Navigator? = null
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: FlowFragmentMainPresenter

    @ProvidePresenter
    internal fun createFlowFragmentMainPresenter(): FlowFragmentMainPresenter {
        createTabsRouterIfNecessary()
        createTabTopNavRouterIfNecessary()
        return FlowFragmentMainPresenter(router, tabsRouter!!.router, tabTopNavRouter!!.router)
    }
    //endregion

    //region Overridden methods
    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider().setLayoutResourceId(R.layout.fragment_navigation_drawer)
                .setToolbarHamburgerColor(R.color.colorYellowDark)
    }

    override fun getPresenter(): FlowFragmentMainPresenter {
        return mPresenter
    }

    override fun provideRouter(): ApplicationRouter {
        return tabsRouter!!.router
    }

    override fun provideTabTopNavRouter(): ApplicationRouter {
        return tabTopNavRouter!!.router
    }

    override fun onResume() {
        createTabsRouterIfNecessary()
        createTabTopNavRouterIfNecessary()
        super.onResume()
        mPresenter.setTabsRouter(tabsRouter!!.router)
        mPresenter.setTabTopNavRouter(tabTopNavRouter!!.router)
    }

    override fun onPause() {
        tabsRouter!!.navigatorHolder.removeNavigator()
        tabTopNavRouter!!.navigatorHolder.removeNavigator()
        super.onPause()
    }
    //endregion

    //region UI
    override fun prepareUI() {

        navigationDrawerNavBottomAboutUs.setOnClickListener { ZUtils.showToastSimple(context!!, "navigationDrawerNavBottomAboutUs") }
        navigationDrawerNavBottomRedaksiya.setOnClickListener { ZUtils.showToastSimple(context!!, "navigationDrawerNavBottomRedaksiya") }
        navigationDrawerNavBottomCallUs.setOnClickListener { ZUtils.showToastSimple(context!!, "navigationDrawerNavBottomCallUs") }
        navigationDrawerNavBottomAdPlacement.setOnClickListener { ZUtils.showToastSimple(context!!, "navigationDrawerNavBottomAdPlacement") }
        navigationDrawerNavBottomPartners.setOnClickListener { ZUtils.showToastSimple(context!!, "navigationDrawerNavBottomPartners") }

        if (fragmentProvider.toolbarHamburgerColor != null)
            toolbar?.setNavigationOnClickListener { drawer_layout.openDrawer(Gravity.START) }

//        navigation.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.nav_menu_menu -> {
//                    toolbar?.setTitle(R.string.text_menu)
//                    mPresenter.onNavTabClicked(Screens.Tabs.nav_tab_menu)
//                }
//                R.id.nav_menu_favorites -> {
//                    toolbar?.setTitle(R.string.text_favorites)
//                    mPresenter.onNavTabClicked(Screens.Tabs.nav_tab_favorites)
//                }
//                R.id.nav_menu_aksiya -> {
//                    toolbar?.setTitle(R.string.text_aksiya)
//                    mPresenter.onNavTabClicked(Screens.Tabs.nav_tab_aksii)
//                }
//                R.id.nav_menu_news -> {
//                    toolbar?.setTitle(R.string.text_news)
//                    mPresenter.onNavTabClicked(Screens.Tabs.nav_tab_news)
//                }
//                else -> return@OnNavigationItemSelectedListener true
//            }
//            drawer_layout.closeDrawer(Gravity.START)
//            true
//        })
    }
    //endregion

    //region Support
    private fun createTabsRouterIfNecessary() {
        if (tabsRouter == null)
            tabsRouter = Cicerone.create(ApplicationRouter())

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

    private fun createTabTopNavRouterIfNecessary() {
        if (tabTopNavRouter == null)
            tabTopNavRouter = Cicerone.create(ApplicationRouter())

        if (tabTopNavNavigator == null)
            tabTopNavNavigator = object : SupportAppNavigator(activity, childFragmentManager, R.id.navigationDrawerFrameLayout) {
                override fun setupFragmentTransaction(
                        command: Command?,
                        currentFragment: Fragment?,
                        nextFragment: Fragment?,
                        fragmentTransaction: FragmentTransaction?
                ) {
                    fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                }
            }
        tabTopNavRouter!!.navigatorHolder.setNavigator(tabTopNavNavigator)
    }

    companion object {
        fun newInstance(): FlowFragmentMain {
            return FlowFragmentMain()
        }
    }
}
