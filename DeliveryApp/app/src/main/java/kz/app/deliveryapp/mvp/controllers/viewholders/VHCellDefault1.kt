package kz.app.deliveryapp.mvp.controllers.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import io.realm.Realm
import kotlinx.android.synthetic.main.vh_cell_default_1.view.*
import kz.app.deliveryapp.di.modules.GlideApp
import kz.app.deliveryapp.mvp.модели.модель_меню.TMenuList
import kz.app.deliveryapp.mvp.основнойКонтейнер.RootContract
import kz.app.deliveryapp.mvp.основнойКонтейнер.RootModel

class VHCellDefault1(
    itemView: View,
    private val onDefaultItemClick: (TMenuList) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private val modelRoot: RootContract.Model = RootModel()
    private lateinit var realm: Realm

    //region UI
    fun render(menuList: TMenuList?) {
        menuList?.let {
            itemView.menuTextViewName.text = it.name

            GlideApp.with(itemView.context)
                .load(it.imgUrl)
                .centerCrop()
                .into(itemView.menuImageViewLogo)

            //            val nameString: String = it.personChild?.lastName + " " + it.personChild?.firstName
//            itemView.tvChildrenTitle.text = nameString
//
//            if (it.photoId != null) {
//
//                /*region REALM*/
//                realm = Realm.getDefaultInstance()
//                try {
//                    val photoChild = realm.where(TPhotoChild::class.java).findAll()
//
//                    if (photoChild.size != 0) {
//                        realm.beginTransaction()
//                        for (i in 0 until photoChild.size) {
//                            if (it.id == photoChild[i]!!.idChild) {
//                                itemView.rivCildrenLogo.setImageBitmap(
//                                    BitmapFactory.decodeByteArray(
//                                        photoChild[i]!!.photoBitmap,
//                                        0,
//                                        photoChild[i]!!.photoBitmap!!.size
//                                    )
//                                )
//                                itemView.progressBarChildPhoto.visibility = View.GONE
//                            }
//                        }
//                        realm.commitTransaction()
//                    } else {
//                        getPrevImage(it)
//                    }
//                } finally {
//                    realm.close()
//                }
//                /*endregion*/
//
//            } else {
//                itemView.progressBarChildPhoto.visibility = View.GONE
//                itemView.rivCildrenLogo.setBackgroundResource(R.drawable.photo_placeholder)
//            }

            itemView.setOnClickListener { onDefaultItemClick(menuList) }
        }
    }
}