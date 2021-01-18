package kz.app.bender.mvp.tabsNavigation;

import com.arellomobile.mvp.InjectViewState;

import kz.app.bender.mvp.AbstractPresenter;
import kz.app.bender.support.Config;
import kz.app.bender.support.navigation.BenderRouter;
import kz.app.bender.support.navigation.Screens;
import kz.app.bender.support.navigation.screen.BenderScreen;

@InjectViewState
public class FlowFragmentMainPresenter
        extends AbstractPresenter<FlowFragmentContract.View>
        implements FlowFragmentContract.Presenter {

    //region Vars
    private BenderRouter tabsRouter;
    private BenderScreen screenMain;
    private BenderScreen screenWebSiteTab2;
    private BenderScreen screenWebSiteTab3;
    private FlowFragmentModel flowFragmentModel = new FlowFragmentModel();
    //endregion

    //region Constructor
    FlowFragmentMainPresenter(BenderRouter flowRouter, BenderRouter tabsRouter) {
        super(flowRouter);
        this.tabsRouter = tabsRouter;
    }
    //endregion

    //region Overridden methods
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        onTabClicked(Screens.Tabs.tab_login);
    }

    @Override
    public void onDestroy() {
        screenMain = null;
        screenWebSiteTab2 = null;
        screenWebSiteTab3 = null;
        super.onDestroy();
    }
    //endregion

    //region Actions
    void onTabClicked(Screens.Tabs tab) {
        BenderScreen screen = null;
        if (tab == Screens.Tabs.tab_login) {
            if (screenMain == null) {
                if (flowFragmentModel.getUserData() != null)
                    screenMain = Screens.getTabChildrenList();
                else
                    screenMain = Screens.getTabLogin();
            }
            screen = screenMain;
        } else if (tab == Screens.Tabs.tab_web_site_karlygash) {
            if (screenWebSiteTab2 == null)
                screenWebSiteTab2 = Screens.getTabWebView(Config.URL_SITE_SIMPLE);
            screen = screenWebSiteTab2;
        } else if (tab == Screens.Tabs.tab_web_site_profile) {
            if (screenWebSiteTab3 == null)
                screenWebSiteTab3 = Screens.getTabWebView2(Config.URL_SITE_CABINET);
            screen = screenWebSiteTab3;
        }

        if (screen != null)
            tabsRouter.navigateTo(screen);
    }
    //endregion

    //region Support
    void setTabsRouter(BenderRouter router) {
        this.tabsRouter = router;
    }
    //endregion
}
