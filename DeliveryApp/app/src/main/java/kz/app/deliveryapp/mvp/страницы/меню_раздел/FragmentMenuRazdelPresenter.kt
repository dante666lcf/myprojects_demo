package kz.app.deliveryapp.mvp.страницы.меню_раздел

import com.arellomobile.mvp.InjectViewState
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListMenuRazdel
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem
import kz.app.deliveryapp.mvp.основнойКонтейнер.RootPresenter
import kz.app.deliveryapp.support.навигация.BenderRouter
import kz.app.deliveryapp.support.навигация.Screens

@InjectViewState
class FragmentMenuRazdelPresenter(router: BenderRouter) : AbstractPresenter<FragmentMenuRazdelContract.View>(router),
    FragmentMenuRazdelContract.Presenter {

    private val adapterListMenuRazdel: AdapterListMenuRazdel
    private val arrayListEda = ArrayList<TEdaItem>()

    init {
        adapterListMenuRazdel = AdapterListMenuRazdel(arrayListEda,
            onEdaItemClick = { edaItem ->
                RootPresenter.instance.flowNavigateTo(Screens.getFlowDetailedInfo(edaItem))
            },
            onAddBasketClick = { edaItem ->
                viewState.addToBasket(edaItem)
            },
            onFavoritesClick = { edaItem ->
                viewState.addToFavorites(edaItem)
            }
        )
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getListMenuRazdel()
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun getListMenuRazdel() {
        viewState.setAdapterListMenuRazdel(adapterListMenuRazdel)
    }

    override fun setListMenuRazdelToPresenter(edaList: ArrayList<TEdaItem>) {
        arrayListEda.clear()
        arrayListEda.addAll(edaList)
        adapterListMenuRazdel.notifyDataSetChanged()
    }
}