package kz.app.bender.mvp.tabContainer;

import com.arellomobile.mvp.InjectViewState;
import kz.app.bender.mvp.AbstractPresenter;
import kz.app.bender.support.navigation.BenderRouter;

import kz.app.bender.support.navigation.Screens;
import kz.app.bender.support.navigation.screen.BenderScreen;
import ru.terrakok.cicerone.Screen;

@InjectViewState
public class TabContainerPresenter extends AbstractPresenter<TabContainerContract.View> {

    //region Vars
    private Screen rootScreen;
    //endregion

    //region Constructor
    TabContainerPresenter(BenderRouter tabRouter, BenderScreen rootScreen, Screens.Tabs tabsFragmentKey) {
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
