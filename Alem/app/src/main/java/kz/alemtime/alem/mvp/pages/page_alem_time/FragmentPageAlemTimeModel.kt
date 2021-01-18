package kz.alemtime.alem.mvp.pages.page_alem_time

import kz.alemtime.alem.models.otherModels.TCategoryType
import kz.alemtime.alem.models.otherModels.TPosts
import kz.alemtime.alem.mvp.AbstractModel
import rx.Single

class FragmentPageAlemTimeModel : AbstractModel(), FragmentPageAlemTimeContract.Model {

    override fun getCategoriesType(typeId: Int): Single<ArrayList<TCategoryType>> {
        return createDefaultArrayListRequestSingle(restAPI.getCategoriesType(typeId))
    }

    override fun getPostByCategoryId(categoryId: Int): Single<ArrayList<TPosts>> {
        return createDefaultArrayListRequestSingle(restAPI.getPostByCategoryId(categoryId))
    }

    override fun getPostHot(postHot: Int): Single<ArrayList<TPosts>> {
        return createDefaultArrayListRequestSingle(restAPI.getPostHot(postHot))
    }
}