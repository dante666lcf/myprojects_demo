package kz.app.bender.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TDate : Serializable {

    @Expose
    @SerializedName("date")
    var date: String? = null

}