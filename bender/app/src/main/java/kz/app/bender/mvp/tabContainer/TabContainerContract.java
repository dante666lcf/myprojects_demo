package kz.app.bender.mvp.tabContainer;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import kz.app.bender.mvp.AbstractView;

public interface TabContainerContract {

    interface Model {

    }

    @StateStrategyType(SkipStrategy.class)
    interface View extends AbstractView {

    }

    interface Presenter {

    }
}
