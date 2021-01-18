package kz.app.bender.mvp.root

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.AbstractModel
import kz.app.bender.support.stat.Zprefs
import rx.Single

class RootModel : AbstractModel(), RootContract.Model {

    override fun clearUser() {
        Zprefs.clearUser(sharedPreferences)
    }

    override fun getUser(): TSignIn? {
        return Zprefs.getUser(sharedPreferences)
    }

    override fun getPrevImage(photoId: Int?): Single<String> {
        return Single.create { emitter ->
            restAPI.getPrevImage(photoId)
                    .subscribe({ response ->
                        response.body()?.let {
                            if (it.isSuccess) {
                                emitter.onSuccess(it.data ?: "")
                            } else {
                                emitter.onError(Throwable(it.data, Throwable(it.code.toString())))
                            }
                        }
                    }, emitter::onError)
        }
    }

    override fun getThroughAuthToken(iin: String?): Single<String> {
        return Single.create { emitter ->
            restAPI.getThroughAuthToken(iin)
                    .subscribe({ response ->
                        response.body()?.let {
                            if (it.isSuccess) {
                                emitter.onSuccess(it.data ?: "")
                            } else {
                                emitter.onError(Throwable(it.data, Throwable(it.code.toString())))
                            }
                        }
                    }, emitter::onError)
        }
    }

    override fun getImageChild(encodedDataString: String?): Bitmap {
        val decodedString: String = encodedDataString?.replace("data:image/jpeg;base64,", "") ?: ""
        val imageAsBytes = Base64.decode(decodedString.toByteArray(), 0)

        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
    }

}