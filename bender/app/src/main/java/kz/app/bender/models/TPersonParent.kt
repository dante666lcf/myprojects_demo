package kz.app.bender.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TPersonParent : Serializable {

    @Expose
    @SerializedName("person")
    var personChild: TPersonChild? = null

}