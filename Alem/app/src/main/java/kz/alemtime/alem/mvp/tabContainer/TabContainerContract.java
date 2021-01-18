package kz.alemtime.alem.mvp.tabContainer;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import kz.alemtime.alem.mvp.AbstractView;

public interface TabContainerContract {

    interface Model {

    }

    @StateStrategyType(SkipStrategy.class)
    interface View extends AbstractView {

    }

    interface Presenter {

    }
}
