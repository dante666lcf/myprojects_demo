package kz.app.bender.mvp.tabsNavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import kz.app.bender.R;
import kz.app.bender.mvp.AbstractView;
import kz.app.bender.mvp.IndigoMVPFragment;
import kz.app.bender.support.navigation.BenderRouter;
import kz.app.bender.support.navigation.RouterProvider;
import kz.app.bender.support.navigation.Screens;
import kz.app.bender.support.provider.FragmentProvider;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class FlowFragmentMain extends IndigoMVPFragment<FlowFragmentMainPresenter>
        implements RouterProvider, FlowFragmentContract.View {

    //region Views
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;
    //endregion

    //region Vars
    private Cicerone<BenderRouter> tabsRouter;
    private Navigator tabsNavigator;
    //endregion

    //region DI
    @InjectPresenter
    FlowFragmentMainPresenter mPresenter;

    @ProvidePresenter
    FlowFragmentMainPresenter createFlowFragmentMainPresenter() {
        createTabsRouterIfNecessary();
        return new FlowFragmentMainPresenter(getRouter(), tabsRouter.getRouter());
    }
    //endregion

    //region New instance
    public static FlowFragmentMain newInstance() {
        return new FlowFragmentMain();
    }
    //endregion

    //region Overridden methods
    @NonNull
    @Override
    public FragmentProvider getFragmentProvider() {
        return new FragmentProvider().setLayoutResourceId(R.layout.fragment_tabs_navigation);
    }

    @NonNull
    public FlowFragmentMainPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public BenderRouter provideRouter() {
        return tabsRouter.getRouter();
    }

    @Override
    public void onResume() {
        createTabsRouterIfNecessary();
        super.onResume();
        mPresenter.setTabsRouter(tabsRouter.getRouter());
    }

    @Override
    public void onPause() {
        tabsRouter.getNavigatorHolder().removeNavigator();
        super.onPause();
    }
    //endregion

    //region UI
    @Override
    public void prepareUI() {
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.bottom_bar_main_tab:
                    mPresenter.onTabClicked(Screens.Tabs.tab_login);
                    return true;
                case R.id.bottom_bar_web_site_karlygash:
                    mPresenter.onTabClicked(Screens.Tabs.tab_web_site_karlygash);
                    return true;
                case R.id.bottom_bar_web_site_profile:
                    mPresenter.onTabClicked(Screens.Tabs.tab_web_site_profile);
                    return true;
            }
            return false;
        });
        bottomNavigationView.setSelectedItemId(R.id.bottom_bar_main_tab);
    }
    //endregion

    //region Support
    private void createTabsRouterIfNecessary() {
        if (tabsRouter == null)
            tabsRouter = Cicerone.create(new BenderRouter());

        if (tabsNavigator == null)
            tabsNavigator = new SupportAppNavigator(activity, getChildFragmentManager(), R.id.flFragmentFrame) {
                @Override
                protected void setupFragmentTransaction(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                }
            };
        tabsRouter.getNavigatorHolder().setNavigator(tabsNavigator);
    }
    //endregion
}
