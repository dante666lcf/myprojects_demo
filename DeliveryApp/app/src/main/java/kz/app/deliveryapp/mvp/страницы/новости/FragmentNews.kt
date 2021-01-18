package kz.app.deliveryapp.mvp.страницы.новости

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_news.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListNews
import kz.app.deliveryapp.mvp.модели.модель_новости.TBaseNewsList
import kz.app.deliveryapp.support.провайдерДляТулбара.FragmentProvider
import java.io.IOException
import java.nio.charset.StandardCharsets

class FragmentNews : RootMvpAppCompatFragment<FragmentNewsPresenter>(), FragmentNewsContract.View {

    companion object {
        fun newInstance(): FragmentNews {
            val framgnet = FragmentNews()
            val args = Bundle()
            framgnet.arguments = args
            return framgnet
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentNewsPresenter

    @ProvidePresenter
    internal fun providesFragmentNewsPresenter(): FragmentNewsPresenter {
        return FragmentNewsPresenter(router)
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
            .setLayoutResourceId(R.layout.fragment_news)
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

    override fun getPresenter(): FragmentNewsPresenter {
        return mPresenter
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun setAdapterListNews(adapterListNews: AdapterListNews) {
        recyclerViewNews.layoutManager = GridLayoutManager(activity, 1)
        recyclerViewNews.adapter = adapterListNews
        getWatchesData()
    }

    /* Convert JSON String to BaseWatch Model via GSON */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun getWatchesData() {
        val jsonString = getAssetsJSON("news.json")
        Log.d(TAG, "Json: $jsonString")
        val gson = Gson()
        val baseNewsList = gson.fromJson<TBaseNewsList>(jsonString, TBaseNewsList::class.java)
        mPresenter.setListNewsToPresenter(baseNewsList.newsList)
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