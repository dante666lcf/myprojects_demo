package kz.app.bender.mvp.scanQr.successQr

import com.arellomobile.mvp.InjectViewState
import kz.app.bender.mvp.AbstractPresenter
import kz.app.bender.support.navigation.BenderRouter

@InjectViewState
class ScanQRSuccessPresenter(router: BenderRouter) : AbstractPresenter<ScanQRSuccessView>(router)