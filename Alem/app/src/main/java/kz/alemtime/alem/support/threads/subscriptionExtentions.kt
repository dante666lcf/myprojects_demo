package kz.alemtime.alem.support.threads

import kz.alemtime.alem.mvp.AbstractView
import rx.Completable
import rx.Observable
import rx.Single
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

fun <T> Single<T>.withDefaultSchedulers(): Single<T> = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun Completable.withDefaultSchedulers(): Completable = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.withDefaultSchedulers(): Observable<T> = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.subscribeDefault(): Subscription = withDefaultSchedulers().subscribe()

fun <T> Single<T>.subscribeDefault(onSuccess: (T) -> Unit): Subscription = withDefaultSchedulers()
        .subscribe { onSuccess(it) }


fun <T> Single<T>.subscribeDefault(onSuccess: (T) -> Unit,
                                   onError: (Throwable) -> Unit): Subscription =
        withDefaultSchedulers().subscribe({ onSuccess(it) }, { onError(it) })


fun Completable.subscribeDefault(): Subscription = withDefaultSchedulers().subscribe()


fun Completable.subscribeDefault(onSuccess: () -> Unit): Subscription =
        withDefaultSchedulers().subscribe { onSuccess() }

fun Completable.subscribeDefault(onSuccess: () -> Unit,
                                 onError: (Throwable) -> Unit): Subscription =
        withDefaultSchedulers().subscribe({ onSuccess() }, { onError(it) })

fun <T> Observable<T>.subscribeDefault(onSuccess: (T) -> Unit,
                                       onError: (Throwable) -> Unit): Subscription =
        withDefaultSchedulers().subscribe({ onSuccess(it) }, { onError(it) })


fun <T> Single<T>.subscribeWithDefaultErrorHandling(action: Action1<T>, view: AbstractView): Subscription {
    return subscribe(action, Action1 {
        view.showRequestError(it as Throwable)
        //view.showResponseError(responseResult.code, responseResult.message)
    })
}

fun <T> Single<T>.subscribeWithHideLoadingErrorHandling(action: Action1<T>, view: AbstractView): Subscription {
    return subscribe(action, Action1 {
        //        view.hideLoading()
        view.showRequestError(it as Throwable)
        //viewState.showResponseError(responseResult.code, responseResult.message)
    })
}

//fun <T> Observable<Response<TResponseResult<T>>>.subscribeDefaultNetworkObservable(subscriber: Subscriber<in T>): Subscription {
//    return subscribe({
//        val responseResult = it.body()
//        if (responseResult != null) {
//            if (responseResult.isSuccessful) {
//                subscriber.onNext(responseResult.data)
//            } else {
//                //singleSubscriber.onError()
//                //viewState.showResponseError(responseResult.code, responseResult.message)
//            }
//        } else {
//
//        }
//    }, { subscriber.onError(it) })
//}
//
//fun <T> Single<Response<TResponseResult<T>>>.subscribeDefaultNetworkSingle(singleSubscriber: SingleSubscriber<in T>): Subscription {
//    return subscribe({
//        val responseResult = it.body()
//        if (responseResult != null) {
//            if (responseResult.isSuccessful) {
//                if (responseResult.data != null)
//                    singleSubscriber.onSuccess(responseResult.data)
//                else {
//
//                }
//            } else {
//                //singleSubscriber.onError()
//                //viewState.showResponseError(responseResult.code, responseResult.message)
//            }
//        } else {
//
//        }
//    }, { singleSubscriber.onError(it) })
//}
