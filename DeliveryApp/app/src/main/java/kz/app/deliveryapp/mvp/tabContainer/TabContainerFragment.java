package kz.app.deliveryapp.mvp.tabContainer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import kz.app.deliveryapp.R;
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment;
import kz.app.deliveryapp.support.навигация.BenderRouter;
import kz.app.deliveryapp.support.навигация.RouterProvider;
import kz.app.deliveryapp.support.навигация.Screens;
import kz.app.deliveryapp.support.навигация.screen.BenderScreen;
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class TabContainerFragment extends RootMvpAppCompatFragment<TabContainerPresenter>
        implements TabContainerContract.View, RouterProvider {

    //region Vars
    private Cicerone<BenderRouter> navTabRouterCicerone;
    private Navigator navTabNavigator;
    private Screens.Tabs tabsFragmentKey;
    public static final String EXTRA_TABS_FRAGMENT_KEY = "EXTRA_TABS_FRAGMENT_KEY";
    public static final String EXTRA_ROOT_SCREEN = "EXTRA_ROOT_SCREEN";
    //endregion

    //region DI
    @InjectPresenter
    TabContainerPresenter presenter;

    @ProvidePresenter
    TabContainerPresenter providesTabContainerPresenter() {
        BenderScreen rootScreen = null;
        if (getArguments() != null) {
            rootScreen = getArguments().getParcelable(EXTRA_ROOT_SCREEN);
            tabsFragmentKey = Screens.Tabs.valueOf(getArguments().getString(EXTRA_TABS_FRAGMENT_KEY));
        }
        createTabRouterIfNecessary();
        return new TabContainerPresenter(navTabRouterCicerone.getRouter(), rootScreen, tabsFragmentKey);
    }
    //endregion

    //region New instance
    public static TabContainerFragment newInstance(BenderScreen rootScreen, Screens.Tabs tabsFragmentKey) {
        TabContainerFragment tabContainerFragment = new TabContainerFragment();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_ROOT_SCREEN, rootScreen);
        args.putString(EXTRA_TABS_FRAGMENT_KEY, tabsFragmentKey.name());
        tabContainerFragment.setArguments(args);
        return tabContainerFragment;
    }
    //endregion

    //region Overridden methods
    @NonNull
    @Override
    public FragmentProvider getFragmentProvider() {
        return new FragmentProvider().setLayoutResourceId(R.layout.fragment_tab_container);
    }

    @NonNull
    @Override
    public TabContainerPresenter getPresenter() {
        return presenter;
    }

    @Override
    public BenderRouter provideRouter() {
        return navTabRouterCicerone.getRouter();
    }

    @Override
    public void onResume() {
        createTabRouterIfNecessary();
        super.onResume();
    }

    @Override
    public void onPause() {
        navTabRouterCicerone.getNavigatorHolder().removeNavigator();
        super.onPause();
    }
    //endregion

    //region UI
    @Override
    public void prepareUI() {

    }
    //endregion

    //region Support
    private void createTabRouterIfNecessary() {
        if (navTabRouterCicerone == null)
            navTabRouterCicerone = Cicerone.create(new BenderRouter());

        if (navTabNavigator == null)
            navTabNavigator = new SupportAppNavigator(activity, getChildFragmentManager(), R.id.flContainer) {
                @Override
                protected void setupFragmentTransaction(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                }
            };
        navTabRouterCicerone.getNavigatorHolder().setNavigator(navTabNavigator);
    }

}