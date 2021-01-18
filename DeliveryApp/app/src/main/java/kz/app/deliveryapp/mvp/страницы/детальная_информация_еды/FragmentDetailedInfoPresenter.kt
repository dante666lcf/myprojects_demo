package kz.app.deliveryapp.mvp.страницы.детальная_информация_еды

import com.arellomobile.mvp.InjectViewState
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem
import kz.app.deliveryapp.support.навигация.BenderRouter

@InjectViewState
class FragmentDetailedInfoPresenter(
    router: BenderRouter,
    var edaItem: TEdaItem
) : AbstractPresenter<FragmentDetailedInfoContract.View>(router), FragmentDetailedInfoContract.Presenter {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setInfo(edaItem)
    }

    override fun onStart() {}

    override fun onStop() {}
}
