package kz.app.deliveryapp.mvp.страницы.корзина

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_basket.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListBasket
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem
import kz.app.deliveryapp.support.stat.Zutils
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider


class FragmentBasket : RootMvpAppCompatFragment<FragmentBasketPresenter>(), FragmentBasketContract.View {

    companion object {
        fun newInstance(): FragmentBasket {
            val framgnet = FragmentBasket()
            val args = Bundle()
            framgnet.arguments = args
            return framgnet
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentBasketPresenter

    @ProvidePresenter
    internal fun providesFragmentBasketPresenter(): FragmentBasketPresenter {
        return FragmentBasketPresenter(router)
    }

    override fun getPresenter(): FragmentBasketPresenter {
        return mPresenter
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
            .setLayoutResourceId(R.layout.fragment_basket)
            .setToolbarArrowColor(R.color.colorAccent)
            .setToolbarTitle(getString(R.string.text_basket), R.color.colorAccent)
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroyView() {
        mPresenter.onDestroyView()
        super.onDestroyView()
    }

    override fun prepareUI() {
        mTextViewCreateOrder.setOnClickListener {
            val realm = Realm.getDefaultInstance()
            realm.executeTransaction { realmExecute ->
                realmExecute.delete(TEdaItem::class.java)
            }
            realm.close()
            Zutils.showToastSimple(activity, "Ваш заказ оформлен, вам скоро позвонят )")
            mPresenter.exit()
        }
    }

    override fun setAdapterListBasket(adapterListBasket: AdapterListBasket) {
        recyclerViewBasket.layoutManager = LinearLayoutManager(activity)
        recyclerViewBasket.adapter = adapterListBasket
        mPresenter.setListBasketToPresenter()
    }
}