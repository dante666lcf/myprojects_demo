package kz.app.deliveryapp.mvp.модели.модель_новости

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TNewsItem : Serializable {

    @Expose
    @SerializedName("title")
    var title: String? = null

    @Expose
    @SerializedName("description")
    var description: String? = null

    @Expose
    @SerializedName("date")
    var date: String? = null

    @Expose
    @SerializedName("url_img")
    var urlImg: String? = null
}