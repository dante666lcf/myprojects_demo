package kz.app.bender.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.io.Serializable

class TResponseResult<T> : Serializable {

    @Expose
    @SerializedName("error_code")
    val code: Int = 0

    @Expose
    @SerializedName("message")
    val message: String? = null

    @Expose
    @SerializedName("isSuccess")
    val isSuccess: Boolean = false

    @Expose
    @SerializedName("data")
    val data: T? = null

}
