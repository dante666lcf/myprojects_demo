package kz.alemtime.alem.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TProfile: Serializable {

    @Expose
    @SerializedName("user_id")
    var user_id: Int? = null

    @Expose
    @SerializedName("email")
    var email: String? = null

    @Expose
    @SerializedName("access_token_expires")
    var access_token_expires: Long? = null

    @Expose
    @SerializedName("full_name")
    var full_name: String? = null

}