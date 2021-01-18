package kz.app.bender.mvp.scanQr

import android.graphics.PointF
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.bender.models.TDate
import kz.app.bender.mvp.AbstractView
import rx.Single

interface ScanQRContract {

    interface Model {
        fun postNotChild(childId: String, code: String): Single<TDate>
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun showPermissionError()

        fun resetPointsOverlay()

        fun startCamera(isFrontCamera: Boolean)

        fun setPointsOverlay(points: Array<PointF>)

        fun setChildrenFIO(fioString: String?)

        fun showToast(toast: String)

        fun showProgressBar()

        fun hideProgressBar()

        fun playSound()

        fun getVibration()
    }

    interface Presenter
}