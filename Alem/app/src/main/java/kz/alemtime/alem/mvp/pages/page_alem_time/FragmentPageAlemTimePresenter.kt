package kz.alemtime.alem.mvp.pages.page_alem_time

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.controllers.adapters.AdapterListCategoriesType32
import kz.alemtime.alem.controllers.adapters.AdapterListPostsByCategory
import kz.alemtime.alem.models.otherModels.TCategoryType
import kz.alemtime.alem.models.otherModels.TPosts
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.support.navigation.ApplicationRouter
import kz.alemtime.alem.support.threads.withDefaultSchedulers
import java.util.*

@InjectViewState
class FragmentPageAlemTimePresenter(
        router: ApplicationRouter
) : AbstractPresenter<FragmentPageAlemTimeContract.View>(router), FragmentPageAlemTimeContract.Presenter {

    private val adapterListCategoriesType32: AdapterListCategoriesType32
    private val adapterListPostsByCategory: AdapterListPostsByCategory
    private val categoriesType32 = ArrayList<TCategoryType>()
    private val postByCategory = ArrayList<TPosts>()
    private val modelAlemTimePage: FragmentPageAlemTimeContract.Model = FragmentPageAlemTimeModel()

    init {
        adapterListCategoriesType32 = AdapterListCategoriesType32(categoriesType32) {
            viewState.setBigTitleCategory(it.name.toString())
            getPostByCategoryId(it.id!!)
        }

        adapterListPostsByCategory = AdapterListPostsByCategory(postByCategory) {
            /*TODO: открыть подробную страницу поста...*/
            viewState.showSimpleToast("В Разработке, но название поста - " + it.title)
        }
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getCategoriesType(32)
        getPostHot(1)
    }

    override fun getCategoriesType(typeId: Int) {
        val subscriptionGetCategoriesType32 = modelAlemTimePage.getCategoriesType(typeId)
                .withDefaultSchedulers()
                .subscribe({
                    categoriesType32.clear()
                    categoriesType32.addAll(it)
                    viewState.showRVTopCategories(adapterListCategoriesType32)
                    adapterListCategoriesType32.notifyDataSetChanged()
                    getPostByCategoryId(it[0].id!!)
                    viewState.setBigTitleCategory(it[0].name.toString())
                }, {
                    Log.e("getCategoriesType", it.message.toString())
                })
        connectionSubscriptions.add(subscriptionGetCategoriesType32)
    }

    override fun getPostByCategoryId(categoryId: Int) {
        val subscriptionGetPostsByCategories = modelAlemTimePage.getPostByCategoryId(categoryId)
                .withDefaultSchedulers()
                .subscribe({
                    postByCategory.clear()
                    postByCategory.addAll(it)
                    viewState.showRVPostByCategory(adapterListPostsByCategory)
                    adapterListPostsByCategory.notifyDataSetChanged()
                }, {
                    Log.e("getPostByCategoryId", it.message.toString())
                })
        connectionSubscriptions.add(subscriptionGetPostsByCategories)
    }

    override fun getPostHot(postHot: Int) {
        val subscriptionGetPostHot = modelAlemTimePage.getPostHot(postHot)
                .withDefaultSchedulers()
                .subscribe({
                    viewState.setPostHot(it[0])
                }, {
                    Log.e("getPostHot", it.message.toString())
                })
        connectionSubscriptions.add(subscriptionGetPostHot)
    }
}