package kz.app.deliveryapp.mvp.tabContainer;

import com.arellomobile.mvp.InjectViewState;
import kz.app.deliveryapp.mvp.AbstractPresenter;
import kz.app.deliveryapp.support.навигация.BenderRouter;
import kz.app.deliveryapp.support.навигация.Screens;
import kz.app.deliveryapp.support.навигация.screen.BenderScreen;
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
