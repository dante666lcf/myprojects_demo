package kz.app.deliveryapp.mvp.страницы.акции

import com.arellomobile.mvp.InjectViewState
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListAksii
import kz.app.deliveryapp.mvp.модели.модель_акции.THotItem
import kz.app.deliveryapp.support.навигация.BenderRouter

@InjectViewState
class FragmentAksiiPresenter(
    router: BenderRouter
) : AbstractPresenter<FragmentAksiiContract.View>(router), FragmentAksiiContract.Presenter {

    private val adapterListAksii: AdapterListAksii
    private val arrayList = ArrayList<THotItem>()

    init {
        adapterListAksii = AdapterListAksii(arrayList) {
            //            router.navigateTo(Screens.getMenuRazdelList(it.type))
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getListAksii()
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun getListAksii() {
        viewState.setAdapterListAksii(adapterListAksii)
    }

    override fun setListAksiiToPresenter(hotItem: ArrayList<THotItem>) {
        arrayList.clear()
        arrayList.addAll(hotItem)
        adapterListAksii.notifyDataSetChanged()
    }
}