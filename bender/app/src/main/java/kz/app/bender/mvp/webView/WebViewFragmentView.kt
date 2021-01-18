package kz.app.bender.mvp.webView

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.bender.mvp.AbstractView

@StateStrategyType(AddToEndSingleStrategy::class)
interface WebViewFragmentView : AbstractView