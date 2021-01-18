package kz.app.bender.mvp.login

import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.AbstractModel
import kz.app.bender.support.stat.Zprefs
import rx.Single

class LoginModel : AbstractModel(), LoginContract.Model {

    override fun postAuth(iin: String, code: String): Single<TSignIn> {
        return createDefaultRequestSingle(restAPI.postAuthUser(iin, code))
    }

    override fun postSendCode(iin: String): Single<Any?> {
        return Single.create { emitter ->
            restAPI.postSendCode(iin)
                    .subscribe({ response ->
                        response.body()?.let {
                            if (it.isSuccess) {
                                emitter.onSuccess(it.message ?: "")
                            } else {
                                emitter.onError(Throwable(it.message, Throwable(it.code.toString())))
                            }
                        }
                    }, emitter::onError)
        }
    }

    override fun setUserData(signIn: TSignIn) {
        Zprefs.setUser(signIn, sharedPreferences)
    }

    override fun getUserData(): TSignIn? {
        return Zprefs.getUser(sharedPreferences)
    }

}