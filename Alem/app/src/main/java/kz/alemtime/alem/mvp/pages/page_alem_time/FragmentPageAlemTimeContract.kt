package kz.alemtime.alem.mvp.pages.page_alem_time

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import kz.alemtime.alem.controllers.adapters.AdapterListCategoriesType32
import kz.alemtime.alem.controllers.adapters.AdapterListPostsByCategory
import kz.alemtime.alem.models.otherModels.TCategoryType
import kz.alemtime.alem.models.otherModels.TPosts
import kz.alemtime.alem.mvp.AbstractView
import rx.Single

interface FragmentPageAlemTimeContract {

    interface Model {
        fun getCategoriesType(typeId: Int): Single<ArrayList<TCategoryType>>

        fun getPostByCategoryId(categoryId: Int): Single<ArrayList<TPosts>>

        fun getPostHot(postHot: Int): Single<ArrayList<TPosts>>
    }

    @StateStrategyType(AddToEndSingleStrategy::class)
    interface View : AbstractView {
        fun showRVTopCategories(adapterListCategoriesType32: AdapterListCategoriesType32)

        fun showRVPostByCategory(adapterListPostsByCategory: AdapterListPostsByCategory)

        fun setBigTitleCategory(textCategory: String)

        fun setWordOfTheDay()

        fun setPostHot(postHot: TPosts)

        fun showSimpleToast(testToast: String)
    }

    interface Presenter {
        fun getCategoriesType(typeId: Int)

        fun getPostByCategoryId(categoryId: Int)

        fun getPostHot(postHot: Int)
    }
}