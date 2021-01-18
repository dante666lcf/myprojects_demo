package kz.app.deliveryapp.mvp.модели.модель_новости

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TBaseNewsList : Serializable {

    @SerializedName("news_list")
    @Expose
    var newsList: ArrayList<TNewsItem> = ArrayList()

}