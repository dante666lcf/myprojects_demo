package kz.alemtime.alem.mvp.tabContainer;

import com.arellomobile.mvp.InjectViewState;
import kz.alemtime.alem.mvp.AbstractPresenter;
import kz.alemtime.alem.support.navigation.ApplicationRouter;
import kz.alemtime.alem.support.navigation.Screens;
import kz.alemtime.alem.support.navigation.screen.ApplicationScreen;
import ru.terrakok.cicerone.Screen;

@InjectViewState
public class TabContainerPresenter extends AbstractPresenter<TabContainerContract.View> {

    //region Vars
    private Screen rootScreen;
    //endregion

    //region Constructor
    TabContainerPresenter(ApplicationRouter tabRouter, ApplicationScreen rootScreen, Screens.Tabs tabsFragmentKey) {
        super(tabRouter);
        this.rootScreen = rootScreen;
    }
    //endregion

    //region Overridden methods
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getRouter().newRootScreen(rootScreen);
        notifyTabSelected();
    }

    @Override
    public void onShown() {
        super.onShown();
        notifyTabSelected();
    }
    //endregion

    //region Support
    private void notifyTabSelected() {

    }
    //endregion
}
