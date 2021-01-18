package kz.app.bender.mvp.webView

import com.arellomobile.mvp.InjectViewState
import kz.app.bender.mvp.AbstractPresenter
import kz.app.bender.support.navigation.BenderRouter

@InjectViewState
class WebViewFragmentPresenter(router: BenderRouter) : AbstractPresenter<WebViewFragmentView>(router)
