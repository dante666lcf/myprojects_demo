package kz.app.deliveryapp.mvp.модели.модель_еды

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.io.Serializable

@RealmClass
open class TEdaItem(
    @Expose
    @SerializedName("id")
    @PrimaryKey
    var id: String? = null
) : Serializable, RealmObject() {

    @Expose
    @SerializedName("title")
    var title: String? = null

    @Expose
    @SerializedName("description")
    var description: String? = null

    @Expose
    @SerializedName("is_new")
    var isNew: Boolean? = false

    @Expose
    @SerializedName("is_favorite")
    var isFavorite: Boolean? = false

    @Expose
    @SerializedName("price")
    var price: Int? = null

    @Expose
    @SerializedName("type_in_menu")
    var typeInMenu: String? = null

    @Expose
    @SerializedName("url_img")
    var urlImg: String? = null
}