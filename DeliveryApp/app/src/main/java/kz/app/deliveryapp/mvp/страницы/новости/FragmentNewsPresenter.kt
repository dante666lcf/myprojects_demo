package kz.app.deliveryapp.mvp.страницы.новости

import com.arellomobile.mvp.InjectViewState
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListNews
import kz.app.deliveryapp.mvp.модели.модель_новости.TNewsItem
import kz.app.deliveryapp.support.навигация.BenderRouter

@InjectViewState
class FragmentNewsPresenter(
    router: BenderRouter
) : AbstractPresenter<FragmentNewsContract.View>(router), FragmentNewsContract.Presenter {

    private val adapterListNews: AdapterListNews
    private val arrayList = ArrayList<TNewsItem>()

    init {
        adapterListNews = AdapterListNews(arrayList) {
            //            router.navigateTo(Screens.getMenuRazdelList(it.type))
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getListNews()
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun getListNews() {
        viewState.setAdapterListNews(adapterListNews)
    }

    override fun setListNewsToPresenter(newsItems: ArrayList<TNewsItem>) {
        arrayList.clear()
        arrayList.addAll(newsItems)
        adapterListNews.notifyDataSetChanged()
    }
}