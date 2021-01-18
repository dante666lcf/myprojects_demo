package kz.app.bender.mvp.scanQr

import android.content.Context
import android.graphics.PointF
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.dlazaro66.qrcodereaderview.QRCodeReaderView
import kotlinx.android.synthetic.main.fragment_scan_qr.*
import kz.app.bender.R
import kz.app.bender.models.TChildrenItem
import kz.app.bender.mvp.IndigoMVPFragment
import kz.app.bender.mvp.root.RootPresenter
import kz.app.bender.support.provider.FragmentProvider
import kz.app.bender.support.stat.Zutils

class ScanQRFragment : IndigoMVPFragment<ScanQRPresenter>(),
        ScanQRContract.View,
        QRCodeReaderView.OnQRCodeReadListener {

    private var qrCodeReaderView: QRCodeReaderView? = null

    //region Companion
    companion object {
        fun newInstance(childrenItem: TChildrenItem): ScanQRFragment {
            val fragment = ScanQRFragment()
            val args = Bundle()
            args.putSerializable("CHILDREN_ITEM", childrenItem)
            fragment.arguments = args
            return fragment
        }
    }
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: ScanQRPresenter

    @ProvidePresenter
    internal fun providesScanQRPresenter(): ScanQRPresenter {
        return ScanQRPresenter(router, arguments?.getSerializable("CHILDREN_ITEM") as TChildrenItem?)
    }

    override fun getPresenter(): ScanQRPresenter {
        return mPresenter
    }
    //endregion

    override fun onQRCodeRead(url: String, points: Array<PointF>) {
        mPresenter.onQrCodeRead(url, points)
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setLayoutResourceId(R.layout.fragment_scan_qr)
                .setHasOptions(true)
                .setToolbarTitle(getString(R.string.scan_code))
                .setToolbarArrowColor(R.color.colorPrimary)
    }

    override fun prepareUI() {

    }

    //region Scan
    override fun setChildrenFIO(fioString: String?) {
        tvChildrenFIO.text = fioString
    }

    override fun showPermissionError() {
        Zutils.showToastSimple(activity, getString(R.string.qr_required))
    }

    override fun resetPointsOverlay() {
        pointsOverlayView?.setPoints(null)
    }

    override fun startCamera(isFrontCamera: Boolean) {
        flCameraFrame.removeAllViews()
        val view = layoutInflater.inflate(R.layout.flow_layout_qr_code_reader_view, flCameraFrame, true)
        qrCodeReaderView = view.findViewById(R.id.qrCodeReaderView)
        qrCodeReaderView?.let {
            it.setQRDecodingEnabled(true)
            it.setOnQRCodeReadListener(this)
            it.setAutofocusInterval(1000L)
            if (isFrontCamera)
                it.setFrontCamera()
            else
                it.setBackCamera()
            it.post { it.startCamera() }
        }
    }

    override fun setPointsOverlay(points: Array<PointF>) {
        pointsOverlayView?.setPoints(points)
    }

    override fun showToast(toast: String) {
        Zutils.showToastSimple(activity, toast)
    }

    override fun showProgressBar() {
        progressBarFocusView.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBarFocusView.visibility = View.GONE
    }

    override fun playSound() {
        try {
            val notify = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val r = RingtoneManager.getRingtone(activity, notify)
            r.play()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getVibration() {
        val vibrator = activity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            //deprecated in API 26
            vibrator.vibrate(100)
        }
    }
    //endregion

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.drop_menu, menu)
        val childrenItem: TChildrenItem? = arguments?.getSerializable("CHILDREN_ITEM") as TChildrenItem?
        menu?.getItem(0)!!.title = childrenItem?.pupilRepresentative?.get(0)?.personChild?.lastName + " " + childrenItem?.pupilRepresentative?.get(0)?.personChild?.firstName + " " + childrenItem?.pupilRepresentative?.get(0)?.personChild?.middleName
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle item selection
        when (item!!.itemId) {
            R.id.menu_drop_action_exit -> {
                RootPresenter.instance.clearUser()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}