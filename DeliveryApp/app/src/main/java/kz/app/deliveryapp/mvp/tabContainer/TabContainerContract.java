package kz.app.deliveryapp.mvp.tabContainer;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import kz.app.deliveryapp.mvp.AbstractView;

public interface TabContainerContract {

    interface Model {

    }

    @StateStrategyType(SkipStrategy.class)
    interface View extends AbstractView {

    }

    interface Presenter {

    }
}
