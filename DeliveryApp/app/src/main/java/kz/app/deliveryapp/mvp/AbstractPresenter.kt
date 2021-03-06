package kz.app.deliveryapp.mvp

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.View
import com.arellomobile.mvp.MvpPresenter
import kz.app.deliveryapp.di.DIWrapper
import kz.app.deliveryapp.support.навигация.BenderRouter


abstract class AbstractPresenter<T : AbstractView>(
    protected var router: BenderRouter
) : MvpPresenter<T>() {

    private var isExited: Boolean = false
    protected var model: AbstractModel = AbstractModel()
    protected var diWrapper: DIWrapper = DIWrapper()
//    protected val connectionSubscriptions = ArraySet<Subscription>()
    //endregion

    //region Life cycle
    @CallSuper
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.prepareUI()
    }

    @CallSuper
    open fun onCreateView(rootView: View?, savedInstanceState: Bundle?) {

    }

    open fun onStart() {}

    open fun onResume(router: BenderRouter) {
        this.router = router
    }

    open fun onHidden() {}

    open fun onShown() {}

    open fun onPause() {}

    open fun onStop() {}

    open fun onDestroyView() {}

    override fun onDestroy() {
        super.onDestroy()
//        for (subscription in connectionSubscriptions)
//            Zutils.unsubscribeSafely(subscription)
    }
    //endregion

    //region Actions
    open fun onBackPressed(): Boolean {
        return false
    }

    open fun openDrawer() {}

    open fun exit() {
        if (!onBackPressed()) {
            if (!isExited)
                router.exit()
            isExited = true
        }
    }
    //endregion
}
