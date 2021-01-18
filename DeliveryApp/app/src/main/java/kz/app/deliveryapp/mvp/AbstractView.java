package kz.app.deliveryapp.mvp;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface AbstractView extends MvpView {
    void prepareUI();

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showRequestError(Throwable throwable);

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showResponseError(int responseResultCode, String responseResultMessage);
}