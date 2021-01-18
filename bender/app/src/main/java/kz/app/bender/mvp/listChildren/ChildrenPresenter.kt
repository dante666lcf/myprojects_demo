package kz.app.bender.mvp.listChildren

import com.arellomobile.mvp.InjectViewState
import io.realm.Realm
import kz.app.bender.controllers.adapters.AdapterListChildren
import kz.app.bender.models.TChildrenItem
import kz.app.bender.models.TPhotoChild
import kz.app.bender.mvp.AbstractPresenter
import kz.app.bender.support.navigation.BenderRouter
import kz.app.bender.support.navigation.Screens
import kz.app.bender.support.threads.withDefaultSchedulers
import java.util.*

@InjectViewState
class ChildrenPresenter(router: BenderRouter)
    : AbstractPresenter<ChildrenContract.View>(router), ChildrenContract.Presenter {

    private val adapterListChildren: AdapterListChildren
    private val childrenItems = ArrayList<TChildrenItem>()
    private val modelChildren: ChildrenContract.Model = ChildrenModel()
    private lateinit var realmPhotoChild: Realm

    init {
        adapterListChildren = AdapterListChildren(childrenItems, {
            router.navigateTo(Screens.getScanQR(it))
        }, { childrenItem, byteArray ->
            //            createObjectRealmPhotoChild(
            realmPhotoChild.beginTransaction()
            val photoChild = realmPhotoChild.createObject(TPhotoChild::class.java, UUID.randomUUID().toString())
            photoChild.idChild = childrenItem.id
            photoChild.photoId = childrenItem.photoId!!
            photoChild.photoBitmap = byteArray
            realmPhotoChild.commitTransaction()
        })
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        realmPhotoChild = Realm.getDefaultInstance()
        getChildrenList()
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun onDestroyView() {
        realmPhotoChild.close()
    }

    override fun getChildrenList() {
        val subscriptionGetChildrenList = modelChildren.getMyChildren()
                .withDefaultSchedulers()
                .subscribe({
                    childrenItems.addAll(it)
                    if (childrenItems.size > 1) {
                        viewState.setChildrenList(adapterListChildren, 2)
                    } else {
                        viewState.setChildrenList(adapterListChildren, 1)
                    }
                    adapterListChildren.notifyDataSetChanged()

                    setMenuItemFIO()

                }, {
                    viewState.showRequestError(it)
                })
        connectionSubscriptions.add(subscriptionGetChildrenList)
    }

    fun setMenuItemFIO() {
        //set FIO in menuItem
        if (childrenItems.size != 0) {
            val fioString: String? = childrenItems[0].pupilRepresentative?.get(0)?.personChild?.lastName + " " + childrenItems[0].pupilRepresentative?.get(0)?.personChild?.firstName + " " + childrenItems[0].pupilRepresentative?.get(0)?.personChild?.middleName
            viewState.changeFIOinItemMenu(fioString)
        }
    }
}