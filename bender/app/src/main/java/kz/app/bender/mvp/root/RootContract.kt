package kz.app.bender.mvp.root

import android.graphics.Bitmap
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.AbstractView
import rx.Single

interface RootContract {

    interface Model {
        fun getImageChild(encodedDataString: String?): Bitmap

        fun getPrevImage(photoId: Int?): Single<String>

        fun getThroughAuthToken(iin: String?): Single<String>

        fun clearUser()

        fun getUser(): TSignIn?
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView

    interface Presenter

}