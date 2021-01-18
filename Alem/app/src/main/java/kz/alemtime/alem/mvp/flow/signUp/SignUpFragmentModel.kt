package kz.alemtime.alem.mvp.flow.signUp

import kz.alemtime.alem.models.TResponseResultAuthRegistration
import kz.alemtime.alem.mvp.AbstractModel
import kz.alemtime.alem.support.threads.withDefaultSchedulers
import rx.Single

class  SignUpFragmentModel: AbstractModel(), SignUpFragmentContract.Model {

    override fun postAuthRegistration(username: String, email: String, password: String): Single<TResponseResultAuthRegistration> {
        return Single.create { subscriber ->
            restAPI.postAuthRegistration(username, email, password)
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