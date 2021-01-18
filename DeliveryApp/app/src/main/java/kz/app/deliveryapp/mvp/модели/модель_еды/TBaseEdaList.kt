package kz.app.deliveryapp.mvp.модели.модель_еды

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TBaseEdaList : Serializable {

    @SerializedName("eda_list")
    @Expose
    var edaList: ArrayList<TEdaItem> = ArrayList()

}