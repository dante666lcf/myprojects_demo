package kz.alemtime.alem.mvp.tabsNavigation

import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter
import kz.alemtime.alem.support.navigation.Screens
import kz.alemtime.alem.support.navigation.screen.ApplicationScreen

@InjectViewState
class FlowFragmentMainPresenter(
        flowRouter: ApplicationRouter,
        private var tabsRouter: ApplicationRouter?,
        private var tabTopNavRouter: ApplicationRouter?
) : AbstractPresenter<FlowFragmentContract.View>(flowRouter), FlowFragmentContract.Presenter {

    private var screenAlemTime: ApplicationScreen? = null
    private var screenEldiMekender: ApplicationScreen? = null
    private var screenTopNavDrawer: ApplicationScreen? = null

    companion object {
        lateinit var instance: FlowFragmentMainPresenter
    }

    init {
        instance = this
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        onNavTabClicked(Screens.Tabs.nav_tab_alem_time)
        onNavTabClicked(Screens.Tabs.nav_place_top_drawer)
    }

    override fun onDestroy() {
        screenAlemTime = null
        screenEldiMekender = null
        screenTopNavDrawer = null
        super.onDestroy()
    }

    fun onNavTabClicked(tab: Screens.Tabs) {
        var screenDrawerMenu: ApplicationScreen? = null
        var screenDrawerTopPlace: ApplicationScreen? = null
        when (tab) {
            Screens.Tabs.nav_tab_alem_time -> {
                if (screenAlemTime == null)
                    screenAlemTime = Screens.getNavAlemTime()
                screenDrawerMenu = screenAlemTime
            }
            Screens.Tabs.nav_tab_eldi_mekender -> {
                if (screenEldiMekender == null)
                    screenEldiMekender = Screens.getNavEldiMekender()
                screenDrawerMenu = screenEldiMekender
            }
            Screens.Tabs.nav_place_top_drawer -> {
                if (screenTopNavDrawer == null)
                    screenTopNavDrawer = Screens.getDrawerMenu()
                screenDrawerTopPlace = screenTopNavDrawer
            }
        }

        if (screenDrawerMenu != null)
            tabsRouter!!.navigateTo(screenDrawerMenu)

        if (screenDrawerTopPlace != null)
            tabTopNavRouter!!.navigateTo(screenDrawerTopPlace)
    }

    fun setTabsRouter(router: ApplicationRouter) {
        this.tabsRouter = router
    }

    fun setTabTopNavRouter(router: ApplicationRouter) {
        this.tabTopNavRouter = router
    }
}
