package kz.alemtime.alem.mvp.flow.login

import kz.alemtime.alem.models.TResponseResultAuth
import kz.alemtime.alem.mvp.AbstractModel
import kz.alemtime.alem.support.threads.withDefaultSchedulers
import rx.Single

class LoginModel : AbstractModel(), LoginContract.Model {

    override fun postAuth(email: String, password: String): Single<TResponseResultAuth> {
        return Single.create { subscriber ->
            restAPI.postAuth(email, password)
                    .withDefaultSchedulers()
                    .subscribe({ response ->
                        if (response != null) {
                            if (response.isSuccessful && response.code() != 0)
                                subscriber.onSuccess(response.body())
                            else
                                subscriber.onError(Throwable(response.message(), Throwable(response.code().toString())))
                        } else
                            subscriber.onError(null)
                    }, {
                        subscriber.onError(it)
                    })
        }
    }
}