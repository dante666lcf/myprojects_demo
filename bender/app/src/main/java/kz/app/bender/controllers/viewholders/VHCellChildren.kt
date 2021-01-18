package kz.app.bender.controllers.viewholders

import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Base64
import android.view.View
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.vh_cell_children.view.*
import kz.app.bender.R
import kz.app.bender.models.TChildrenItem
import kz.app.bender.models.TPhotoChild
import kz.app.bender.mvp.root.RootContract
import kz.app.bender.mvp.root.RootModel
import kz.app.bender.support.threads.withDefaultSchedulers


class VHCellChildren(
        itemView: View,
        private val onChildrenClick: (TChildrenItem) -> Unit,
        private val onCreateObject: (TChildrenItem, byteArray: ByteArray) -> Unit)
    : RecyclerView.ViewHolder(itemView) {

    private val modelRoot: RootContract.Model = RootModel()
    private lateinit var realm: Realm

    //region UI
    fun render(childrenItem: TChildrenItem?) {
        childrenItem?.let {
            val nameString: String = it.personChild?.lastName + " " + it.personChild?.firstName
            itemView.tvChildrenTitle.text = nameString

            if (it.photoId != null) {

                /*region REALM*/
                realm = Realm.getDefaultInstance()
                try {
                    val photoChild = realm.where(TPhotoChild::class.java).findAll()

                    if (photoChild.size != 0) {
                        realm.beginTransaction()
                        for (i in 0 until photoChild.size) {
                            if (it.id == photoChild[i]!!.idChild) {
                                itemView.rivCildrenLogo.setImageBitmap(BitmapFactory.decodeByteArray(
                                        photoChild[i]!!.photoBitmap,
                                        0,
                                        photoChild[i]!!.photoBitmap!!.size)
                                )
                                itemView.progressBarChildPhoto.visibility = View.GONE
                            }
                        }
                        realm.commitTransaction()
                    } else {
                        getPrevImage(it)
                    }
                } finally {
                    realm.close()
                }
                /*endregion*/

            } else {
                itemView.progressBarChildPhoto.visibility = View.GONE
                itemView.rivCildrenLogo.setBackgroundResource(R.drawable.photo_placeholder)
            }

            itemView.setOnClickListener { onChildrenClick(childrenItem) }
        }
    }

    private fun getPrevImage(itemChild: TChildrenItem) {
        modelRoot.getPrevImage(itemChild.photoId)
                .withDefaultSchedulers()
                .subscribe({ dataPhoto ->
                    var decodedString: String
                    decodedString = dataPhoto.replace("data:image/png;base64,", "")
                    if (decodedString.length == dataPhoto.length)
                        decodedString = dataPhoto.replace("data:image/jpeg;base64,", "")
                    val imageAsBytes = Base64.decode(decodedString.toByteArray(), 0)
                    itemView.rivCildrenLogo.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size))
                    itemView.progressBarChildPhoto.visibility = View.GONE

                    onCreateObject(itemChild, imageAsBytes)

                }, {
                    Toast.makeText(itemView.context, "ОШИБКА ЗАГРУЗКИ", Toast.LENGTH_LONG).show()
                    itemView.progressBarChildPhoto.visibility = View.GONE
                    itemView.rivCildrenLogo.setBackgroundResource(R.drawable.photo_placeholder)
                })
    }
}