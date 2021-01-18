package kz.app.deliveryapp.mvp.tabsNavigation

import com.arellomobile.mvp.InjectViewState
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.support.навигация.BenderRouter
import kz.app.deliveryapp.support.навигация.Screens
import kz.app.deliveryapp.support.навигация.screen.BenderScreen

@InjectViewState
class FlowFragmentMainPresenter(
    flowRouter: BenderRouter, //region Vars
    private var tabsRouter: BenderRouter?
) : AbstractPresenter<FlowFragmentContract.View>(flowRouter), FlowFragmentContract.Presenter {

    private var screenMenu: BenderScreen? = null
    private var screenFavorites: BenderScreen? = null
    private var screenNews: BenderScreen? = null
    private var screenAksii: BenderScreen? = null

    companion object {
        lateinit var instance: FlowFragmentMainPresenter
    }

    init {
        instance = this
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        onNavTabClicked(Screens.Tabs.nav_tab_menu)
    }

    override fun onDestroy() {
        screenMenu = null
        screenFavorites = null
        screenNews = null
        screenAksii = null
        super.onDestroy()
    }

    fun onNavTabClicked(tab: Screens.Tabs) {
        var screen: BenderScreen? = null
        when (tab) {
            Screens.Tabs.nav_tab_menu -> {
                if (screenMenu == null)
                    screenMenu = Screens.getNavTabMenu()
                screen = screenMenu
            }
            Screens.Tabs.nav_tab_favorites -> {
                if (screenFavorites == null)
                    screenFavorites = Screens.getNavTabMenu()
                screen = screenFavorites
            }
            Screens.Tabs.nav_tab_news -> {
                if (screenNews == null)
                    screenNews = Screens.getNavTabNews()
                screen = screenNews
            }
            Screens.Tabs.nav_tab_aksii -> {
                if (screenAksii == null)
                    screenAksii = Screens.getNavTabAksii()
                screen = screenAksii
            }
        }

        if (screen != null)
            tabsRouter!!.navigateTo(screen)
    }

    fun setTabsRouter(router: BenderRouter) {
        this.tabsRouter = router
    }
}
