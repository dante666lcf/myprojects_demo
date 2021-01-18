package kz.alemtime.alem.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TResponseResultAuthRegistration : Serializable {

//    "status": true,
//    "message": "Successfully signed up",
//    "username": "dante",
//    "email": "dante666lcf@gmail.com"

    @Expose
    @SerializedName("status")
    var status: Boolean = false

    @Expose
    @SerializedName("message")
    var message: String? = null

    @Expose
    @SerializedName("username")
    var username: String? = null

    @Expose
    @SerializedName("email")
    var email: String? = null

}