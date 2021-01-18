package kz.app.deliveryapp.mvp.модели.модель_акции

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TBaseHotList : Serializable {

    @SerializedName("hot_list")
    @Expose
    var горячийБлятьЛист: ArrayList<THotItem> = ArrayList()

}