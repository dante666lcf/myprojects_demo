package kz.app.bender.mvp

import android.content.SharedPreferences
import kz.app.bender.ApplicationMain
import kz.app.bender.models.TResponseResult
import kz.app.bender.rest.RestApi
import kz.app.bender.support.stat.Zvars
import retrofit2.Response
import rx.Observable
import rx.Single
import javax.inject.Inject

open class AbstractModel {

    @Inject
    lateinit var restAPI: RestApi
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    init {
        ApplicationMain.instance.componentNet.inject(this)
    }

    fun <T> createDefaultRequestSingle(responseObservable: Observable<Response<TResponseResult<T>>>): Single<T> {
        return Single.create { emitter ->
            responseObservable.subscribe({ response ->
                response.body()?.let {
                    if (it.isSuccess) {
                        if (it.data != null) {
                            emitter.onSuccess(it.data)
                        } else {
                            emitter.onError(Throwable(Zvars.ERROR_DATA_IS_NULL))
                        }
                    } else {
                        emitter.onError(Throwable(Zvars.ERROR_REQUEST_RESULT_IS_NOT_SUCCESSFUL,
                                Throwable(it.message, Throwable(it.code.toString()))))
                    }
                }
            }, emitter::onError)
        }
    }
}


