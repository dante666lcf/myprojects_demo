package ru.tusur.study.mobile.mvp.abstracts.view.interfaces

import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType


interface ErrorInformativeView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showNoConnectionError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showConnectionError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showNetworkResponseError(message: String?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showNullResponseError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showBackendResponseError(backendErrorCode: Int, message: String?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(title: String?, message: String?)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showActivityNotFoundError()

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showRetryDialog(throwable: Throwable, retryAction: () -> Unit)
}