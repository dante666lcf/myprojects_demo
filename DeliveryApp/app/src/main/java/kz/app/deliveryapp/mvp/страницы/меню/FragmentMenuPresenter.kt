package kz.app.deliveryapp.mvp.страницы.меню

import com.arellomobile.mvp.InjectViewState
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListDefault1
import kz.app.deliveryapp.mvp.модели.модель_меню.TMenuList
import kz.app.deliveryapp.support.навигация.BenderRouter
import kz.app.deliveryapp.support.навигация.Screens

@InjectViewState
class FragmentMenuPresenter(router: BenderRouter) : AbstractPresenter<FragmentMenuContract.View>(router),
    FragmentMenuContract.Presenter {

    private val adapterListMenu: AdapterListDefault1
    private val arrayList = ArrayList<TMenuList>()

    init {
        adapterListMenu = AdapterListDefault1(arrayList) {
            router.navigateTo(Screens.getMenuRazdelList(it.type))
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getListMenu()
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun getListMenu() {
        viewState.setAdapterListMenu(adapterListMenu)
    }

    override fun setListMenuToPresenter(menuList: ArrayList<TMenuList>) {
        arrayList.clear()
        arrayList.addAll(menuList)
        adapterListMenu.notifyDataSetChanged()
    }
}