package kz.app.deliveryapp.mvp.страницы.меню_раздел

import android.content.ContentValues
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.gson.Gson
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_menu_razdel.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListMenuRazdel
import kz.app.deliveryapp.mvp.модели.модель_еды.TBaseEdaList
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider
import kz.app.deliveryapp.support.stat.Zutils
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.*

class FragmentMenuRazdel : RootMvpAppCompatFragment<FragmentMenuRazdelPresenter>(), FragmentMenuRazdelContract.View {

    private var realm: Realm? = null

    companion object {
        fun newInstance(type: String): FragmentMenuRazdel {
            val framgnet = FragmentMenuRazdel()
            val args = Bundle()
            args.putString("ARGS_MENU_TYPE", type)
            framgnet.arguments = args
            return framgnet
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentMenuRazdelPresenter

    @ProvidePresenter
    internal fun providesFragmentMenuRazdelPresenter(): FragmentMenuRazdelPresenter {
        realm = Realm.getDefaultInstance()
        return FragmentMenuRazdelPresenter(router)
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
            .setLayoutResourceId(R.layout.fragment_menu_razdel)
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
        menuRazdelBackToMenu.setOnClickListener { mPresenter.exit() }
    }

    override fun addToBasket(edaItem: TEdaItem) {
        realm?.beginTransaction()
        val edaItemRealm = realm?.createObject(TEdaItem::class.java, UUID.randomUUID().toString())
        edaItem.let {
            edaItemRealm?.title = it.title
            edaItemRealm?.description = it.description
            edaItemRealm?.isNew = it.isNew
            edaItemRealm?.isFavorite = it.isFavorite
            edaItemRealm?.price = it.price
            edaItemRealm?.typeInMenu = it.typeInMenu
            edaItemRealm?.urlImg = it.urlImg
        }
        realm?.commitTransaction()
        Zutils.showToastSimple(activity, "'" + edaItem.title + "' " + "добавлено в корзину!")
    }

    override fun addToFavorites(edaItem: TEdaItem) {
        Zutils.showToastSimple(activity, "Данная функция в разработке")
    }

    override fun getPresenter(): FragmentMenuRazdelPresenter {
        return mPresenter
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun setAdapterListMenuRazdel(adapterListMenuRazdel: AdapterListMenuRazdel) {
        val type = arguments!!.getString("ARGS_MENU_TYPE")
        recyclerViewMenuRazdel.layoutManager = GridLayoutManager(activity, 1)
        recyclerViewMenuRazdel.adapter = adapterListMenuRazdel
        getWatchesData(type!!)
    }

    /* Convert JSON String to BaseWatch Model via GSON */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getWatchesData(type: String) {
        val jsonString = getAssetsJSON("$type.json")
        Log.d(ContentValues.TAG, "Json: $jsonString")
        val gson = Gson()
        val baseEdaList = gson.fromJson<TBaseEdaList>(jsonString, TBaseEdaList::class.java)
        mPresenter.setListMenuRazdelToPresenter(baseEdaList.edaList)
    }

    /* Get File in Assets Folder */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getAssetsJSON(fileName: String): String? {
        var json: String? = null
        try {
            val inputStream = activity.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, StandardCharsets.UTF_8)

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return json
    }
}