package kz.app.bender.mvp.tabContainer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import kz.app.bender.R;
import kz.app.bender.mvp.IndigoMVPFragment;
import kz.app.bender.support.navigation.BenderRouter;
import kz.app.bender.support.navigation.RouterProvider;
import kz.app.bender.support.navigation.Screens;
import kz.app.bender.support.navigation.screen.BenderScreen;
import kz.app.bender.support.provider.FragmentProvider;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class TabContainerFragment extends IndigoMVPFragment<TabContainerPresenter>
        implements TabContainerContract.View, RouterProvider {

    //region Vars
    private Cicerone<BenderRouter> tabRouterCicerone;
    private Navigator tabNavigator;
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
        return new TabContainerPresenter(tabRouterCicerone.getRouter(), rootScreen, tabsFragmentKey);
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
        return tabRouterCicerone.getRouter();
    }

    @Override
    public void onResume() {
        createTabRouterIfNecessary();
        super.onResume();
    }

    @Override
    public void onPause() {
        tabRouterCicerone.getNavigatorHolder().removeNavigator();
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
        if (tabRouterCicerone == null)
            tabRouterCicerone = Cicerone.create(new BenderRouter());

        if (tabNavigator == null)
            tabNavigator = new SupportAppNavigator(activity, getChildFragmentManager(), R.id.flContainer) {
                @Override
                protected void setupFragmentTransaction(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
                    fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                }
            };
        tabRouterCicerone.getNavigatorHolder().setNavigator(tabNavigator);
    }

}