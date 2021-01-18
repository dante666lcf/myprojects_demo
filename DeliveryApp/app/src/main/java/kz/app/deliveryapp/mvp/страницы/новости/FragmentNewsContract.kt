package kz.app.deliveryapp.mvp.страницы.новости

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.app.deliveryapp.mvp.AbstractView
import kz.app.deliveryapp.mvp.controllers.adapters.AdapterListNews
import kz.app.deliveryapp.mvp.модели.модель_новости.TNewsItem

interface FragmentNewsContract {

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun setAdapterListNews(adapterListNews: AdapterListNews)
    }

    interface Presenter {
        fun getListNews()
        fun setListNewsToPresenter(newsItems: ArrayList<TNewsItem>)
    }

}