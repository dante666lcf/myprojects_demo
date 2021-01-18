package kz.app.bender.mvp.scanQr.errorQr

import com.arellomobile.mvp.InjectViewState
import kz.app.bender.mvp.AbstractPresenter
import kz.app.bender.support.navigation.BenderRouter

@InjectViewState
class ScanQRErrorPresenter(router: BenderRouter) : AbstractPresenter<ScanQRErrorView>(router)