package kz.alemtime.alem.mvp

import android.content.SharedPreferences
import kz.alemtime.alem.ApplicationMain
import kz.alemtime.alem.rest.RestAPI
import retrofit2.Response
import rx.Observable
import rx.Single
import javax.inject.Inject

open class AbstractModel {

    @Inject
    lateinit var restAPI: RestAPI
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    init {
        ApplicationMain.instance.componentNet.inject(this)
    }

    fun <T> createDefaultArrayListRequestSingle(responseObservable: Observable<Response<ArrayList<T>>>): Single<ArrayList<T>> {
        return Single.create { emitter ->
            responseObservable.subscribe({ response ->
                response.body()?.let {
                    if (it.size != 0) {
                        emitter.onSuccess(it)
                    } else {
                        //TODO: доделать ошибки
//                        emitter.onError(Throwable(Zvars.ERROR_DATA_IS_NULL))
                    }
                }
            }, emitter::onError)
        }
    }
}


