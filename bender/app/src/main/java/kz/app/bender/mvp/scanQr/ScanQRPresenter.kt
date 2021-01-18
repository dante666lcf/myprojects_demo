package kz.app.bender.mvp.scanQr

import android.Manifest
import android.graphics.PointF
import com.arellomobile.mvp.InjectViewState
import com.tbruyelle.rxpermissions.RxPermissions
import kz.app.bender.models.TChildrenItem
import kz.app.bender.models.TDate
import kz.app.bender.mvp.AbstractPresenter
import kz.app.bender.support.navigation.BenderRouter
import kz.app.bender.support.navigation.Screens
import kz.app.bender.support.threads.withDefaultSchedulers

@InjectViewState
class ScanQRPresenter(
        router: BenderRouter,
        private val childrenItem: TChildrenItem?)
    : AbstractPresenter<ScanQRContract.View>(router), ScanQRContract.Presenter {

    //region Vars
    private var isFrontCamera = false
    private var scanned = false
    private val modelScanQr: ScanQRContract.Model = ScanQRModel()
    //endregion

    //region Overridden methods
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.hideProgressBar()
        val nameString: String = childrenItem?.personChild?.lastName + " " + childrenItem?.personChild?.firstName
        viewState.setChildrenFIO(nameString)
        RxPermissions(diWrapper.activity)
                .request(Manifest.permission.CAMERA)
                .subscribe({ aBoolean ->
                    if (aBoolean) {
                        viewState.startCamera(isFrontCamera)
                    } else
                        onBackPressed()
                }, { viewState.showPermissionError() })
    }

    override fun onResume(router: BenderRouter) {
        super.onResume(router)
        scanned = false
        viewState.resetPointsOverlay()
    }

    override fun onShown() {
        super.onShown()
        scanned = false
        viewState.resetPointsOverlay()
    }

    override fun onHidden() {
        super.onHidden()
        scanned = true
    }

    private fun onQRScanSuccess(date: TDate) {
        scanned = true
        router.replaceScreen(Screens.getScanQrSuccess(date))
    }

    private fun onQRScanError() {
        scanned = true
        router.replaceScreen(Screens.getScanQrError(childrenItem))
    }

    fun onQrCodeRead(url: String, points: Array<PointF>) {
        if (!scanned) {
            viewState.showProgressBar()
            viewState.setPointsOverlay(points)
            postNoteChild(childrenItem?.id.toString(), url)
            viewState.playSound()
            viewState.getVibration()
        }
    }

    fun postNoteChild(childId: String, code: String) {
        val subscriptionPostNoteChild = modelScanQr.postNotChild(childId, code)
                .withDefaultSchedulers()
                .subscribe({
                    if (it != null)
                        onQRScanSuccess(it)
                    else
                        onQRScanError()

                    viewState.hideProgressBar()
                }, {
                    viewState.showRequestError(it)
                })
        connectionSubscriptions.add(subscriptionPostNoteChild)
    }
}