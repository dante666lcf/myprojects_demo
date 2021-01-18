package kz.app.bender.support.threads;

import kz.app.bender.support.stat.Zutils;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class SubscriptionBuilder<Z> {

    private Observable<Z> observable;

    private boolean observeOnMainThread = true;
    private Action1<Z> onNext;
    private Action1<Throwable> onError = Zutils::showRequestError;
    private Action0 onCompleted;

    public SubscriptionBuilder(Observable<Z> observable) {
        this.observable = observable;
    }

    public SubscriptionBuilder observeOnNewThread() {
        observeOnMainThread = false;
        return this;
    }

    public SubscriptionBuilder doOnNext(Action1<Z> onNext) {
        this.onNext = onNext;
        return this;
    }

    public SubscriptionBuilder doOnError(Action1<Throwable> onError) {
        this.onError = onError;
        return this;
    }

    public SubscriptionBuilder doOnCompleted(Action0 onCompleted) {
        this.onCompleted = onCompleted;
        return this;
    }

    public Subscription build() {
        Subscription subscription = null;
        observable = observable.subscribeOn(Schedulers.io())
                .observeOn(observeOnMainThread ? AndroidSchedulers.mainThread() : Schedulers.io());
        if (onNext != null && onError != null && onCompleted != null)
            subscription = observable.subscribe(onNext, onError, onCompleted);
        else if (onNext != null && onError != null)
            subscription = observable.subscribe(onNext, onError);
        else if (onNext != null)
            subscription = observable.subscribe(onNext);

        return subscription == null ? observable.subscribe() : subscription;
    }
}
