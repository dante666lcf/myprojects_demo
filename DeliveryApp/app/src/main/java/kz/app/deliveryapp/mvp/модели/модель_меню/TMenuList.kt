package kz.app.deliveryapp.mvp.модели.модель_меню

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class TMenuList : Serializable {

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("type")
    @Expose
    val type: String? = null

    @SerializedName("img_url")
    @Expose
    val imgUrl: String? = null

}