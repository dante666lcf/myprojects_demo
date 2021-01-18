package kz.app.bender.mvp.scanQr

import kz.app.bender.models.TDate
import kz.app.bender.mvp.AbstractModel
import rx.Single

class ScanQRModel : AbstractModel(), ScanQRContract.Model {
    override fun postNotChild(childId: String, code: String): Single<TDate> {
        return Single.create { emitter ->
            restAPI.postNoteChild(childId, code)
                    .subscribe({ response ->
                        response.body()?.let {
                            if (it.isSuccess) {
                                emitter.onSuccess(it.data)
                            } else if (!it.isSuccess) {
                                emitter.onSuccess(it.data)
                            } else {
                                emitter.onError(Throwable(it.message, Throwable(it.code.toString())))
                            }
                        }
                    }, emitter::onError)
        }
    }
}