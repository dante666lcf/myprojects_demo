package kz.app.deliveryapp.mvp.страницы.корзина

import com.arellomobile.mvp.InjectViewState
import io.realm.Realm
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListBasket
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem
import kz.app.deliveryapp.support.навигация.BenderRouter

@InjectViewState
class FragmentBasketPresenter(router: BenderRouter) : AbstractPresenter<FragmentBasketContract.View>(router),
    FragmentBasketContract.Presenter {

    private val adapterListBasket: AdapterListBasket
    private val arrayListBasketItems = ArrayList<TEdaItem>()
    private var realm: Realm? = null

    init {
        adapterListBasket = AdapterListBasket(arrayListBasketItems) { edaItem, type2 ->
            realm?.executeTransaction { realmObject ->
                val result = realmObject.where(TEdaItem::class.java).equalTo("id", edaItem.id).findAll()
                result.deleteAllFromRealm()
                arrayListBasketItems.removeAt(type2)
                deleteFromRecyclerView(type2)
            }
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        realm = Realm.getDefaultInstance()
        getListBasket()
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun onDestroyView() {
        realm?.close()
        super.onDestroyView()
    }

    override fun getListBasket() {
        viewState.setAdapterListBasket(adapterListBasket)
    }

    private fun deleteFromRecyclerView(position: Int) {
        adapterListBasket.notifyItemRemoved(position)
//        adapterListBasket.notifyDataSetChanged()
    }
    override fun setListBasketToPresenter() {
        realm?.executeTransaction { realmExecute ->
            val dataObjectTransaction = realmExecute.where(TEdaItem::class.java).findAll()
            arrayListBasketItems.clear()
            arrayListBasketItems.addAll(ArrayList(dataObjectTransaction))
            adapterListBasket.notifyDataSetChanged()
        }
    }
}