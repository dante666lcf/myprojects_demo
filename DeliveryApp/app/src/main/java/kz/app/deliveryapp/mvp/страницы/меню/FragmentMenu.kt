package kz.app.deliveryapp.mvp.страницы.меню

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListDefault1
import kz.app.deliveryapp.mvp.модели.модель_меню.TBaseMenuList
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider
import java.io.IOException
import java.nio.charset.StandardCharsets


class FragmentMenu : RootMvpAppCompatFragment<FragmentMenuPresenter>(), FragmentMenuContract.View {

    companion object {
        fun newInstance(): FragmentMenu {
            val framgnet = FragmentMenu()
            val args = Bundle()
            framgnet.arguments = args
            return framgnet
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentMenuPresenter

    @ProvidePresenter
    internal fun providesFragmentMenuPresenter(): FragmentMenuPresenter {
        return FragmentMenuPresenter(router)
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
            .setLayoutResourceId(R.layout.fragment_menu)
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

    override fun prepareUI() {}

    override fun getPresenter(): FragmentMenuPresenter {
        return mPresenter
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun setAdapterListMenu(adapterListMenu: AdapterListDefault1) {
        recyclerViewMenu.layoutManager = GridLayoutManager(activity, 2)
        recyclerViewMenu.adapter = adapterListMenu
        getWatchesData()
    }

    /* Convert JSON String to BaseWatch Model via GSON */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getWatchesData() {
        val jsonString = getAssetsJSON("menu.json")
        Log.d(TAG, "Json: $jsonString")
        val gson = Gson()
        val baseMenuList = gson.fromJson<TBaseMenuList>(jsonString, TBaseMenuList::class.java)
        mPresenter.setListMenuToPresenter(baseMenuList.menuList)
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