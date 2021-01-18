package kz.app.deliveryapp.mvp.страницы.детальная_информация_еды

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_detailed_info.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.di.modules.GlideApp
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider
import kz.app.deliveryapp.support.stat.Zutils
import java.util.*

class FragmentDetailedInfo : RootMvpAppCompatFragment<FragmentDetailedInfoPresenter>(),
    FragmentDetailedInfoContract.View {

    private var realm: Realm? = null
    private var edaItem: TEdaItem? = null

    companion object {
        fun newInstance(edaItem: TEdaItem): FragmentDetailedInfo {
            val framgnet = FragmentDetailedInfo()
            val args = Bundle()
            args.putSerializable("ARGS_EDA_ITEM_DETAILED_INFO", edaItem)
            framgnet.arguments = args
            return framgnet
        }
    }

    private var counterInteger: Int? = 0

    @InjectPresenter
    lateinit var mPresenter: FragmentDetailedInfoPresenter

    @ProvidePresenter
    internal fun providesFragmentDetailedInfoPresenter(): FragmentDetailedInfoPresenter {
        val menuItemDetailedInfo: TEdaItem = arguments!!.getSerializable("ARGS_EDA_ITEM_DETAILED_INFO") as TEdaItem
        return FragmentDetailedInfoPresenter(router, menuItemDetailedInfo)
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
            .setLayoutResourceId(R.layout.fragment_detailed_info)
            .setToolbarArrowColor(R.color.colorAccent)
            .setToolbarTitle("Раздел тест", R.color.colorAccent)
    }

    override fun onStart() {
        super.onStart()
        realm = Realm.getDefaultInstance()
        mPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroyView() {
        realm?.close()
        mPresenter.onDestroyView()
        super.onDestroyView()
    }

    override fun prepareUI() {
        detailedInfoImageViewMinus.setOnClickListener {
            if (counterInteger == 0) {
                Zutils.showToastSimple(activity, "В минус нельзя :(")
            } else {
                counterInteger = counterInteger?.minus(1)
                detailedInfoTextViewCounter.text = counterInteger.toString()
            }
        }

        detailedInfoImageViewPlus.setOnClickListener {
            if (counterInteger == 999) {
                Zutils.showToastSimple(activity, "Зачем тебе больше :D")
            } else {
                counterInteger = counterInteger?.plus(1)
                detailedInfoTextViewCounter.text = counterInteger.toString()
            }
        }

        detailedInfoButtonAddToBasket.setOnClickListener {
            if (counterInteger == 0) {
                Zutils.showToastSimple(activity, "`0` нельзя добавить в корзину :|")
            } else {
                for (i in 1..counterInteger!!) {
                    realm?.beginTransaction()
                    val edaItemRealm = realm?.createObject(TEdaItem::class.java, UUID.randomUUID().toString())
                    edaItem?.let {
                        edaItemRealm?.title = it.title
                        edaItemRealm?.description = it.description
                        edaItemRealm?.isNew = it.isNew
                        edaItemRealm?.isFavorite = it.isFavorite
                        edaItemRealm?.price = it.price
                        edaItemRealm?.typeInMenu = it.typeInMenu
                        edaItemRealm?.urlImg = it.urlImg
                    }
                    realm?.commitTransaction()
                }
                Zutils.showToastSimple(activity, "'" + edaItem?.title + "' " + "добавлено в корзину!")
            }
        }
    }

    override fun setInfo(edaItem: TEdaItem) {
        this.edaItem = edaItem
        detailedInfoTextViewTitle.text = edaItem.title
        detailedInfoTextViewDescription.text = edaItem.description
        detailedInfoTextViewPrice.text = getString(R.string.price_with_kzt, edaItem.price.toString())

        GlideApp.with(context!!)
            .load(edaItem.urlImg)
            .centerCrop()
            .into(detailedInfoImageViewLogo)
    }

    override fun getPresenter(): FragmentDetailedInfoPresenter {
        return mPresenter
    }

}