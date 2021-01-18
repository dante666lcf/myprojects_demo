package kz.app.deliveryapp.mvp.страницы.акции

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_hot.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListAksii
import kz.app.deliveryapp.mvp.модели.модель_акции.TBaseHotList
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider
import java.io.IOException
import java.nio.charset.StandardCharsets

class FragmentAksii : RootMvpAppCompatFragment<FragmentAksiiPresenter>(), FragmentAksiiContract.View {

    companion object {
        fun newInstance(): FragmentAksii {
            val framgnet = FragmentAksii()
            val args = Bundle()
            framgnet.arguments = args
            return framgnet
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentAksiiPresenter

    @ProvidePresenter
    internal fun providesFragmentAksiiPresenter(): FragmentAksiiPresenter {
        return FragmentAksiiPresenter(router)
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
            .setLayoutResourceId(R.layout.fragment_hot)
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

    override fun getPresenter(): FragmentAksiiPresenter {
        return mPresenter
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun setAdapterListAksii(adapterListAksii: AdapterListAksii) {
        recyclerViewAksii.layoutManager = GridLayoutManager(activity, 1)
        recyclerViewAksii.adapter = adapterListAksii
        getWatchesData()
    }

    /* Convert JSON String to BaseWatch Model via GSON */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getWatchesData() {
        val jsonString = getAssetsJSON("hot.json")
        Log.d(TAG, "Json: $jsonString")
        val gson = Gson()
        val baseHotList = gson.fromJson<TBaseHotList>(jsonString, TBaseHotList::class.java)
        mPresenter.setListAksiiToPresenter(baseHotList.горячийБлятьЛист)
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