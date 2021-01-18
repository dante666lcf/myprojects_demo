package kz.app.bender.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TSignIn : Serializable {

    @Expose
    @SerializedName("Id")
    val id: Int = 0

    @Expose
    @SerializedName("Login")
    val loginIIN: Long = 0

    @Expose
    @SerializedName("PersonId")
    val personId: Int = 0

}