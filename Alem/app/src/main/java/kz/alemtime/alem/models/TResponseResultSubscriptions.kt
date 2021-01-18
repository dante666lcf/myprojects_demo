package kz.alemtime.alem.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TResponseResultSubscriptions : Serializable {

//    "id": 14,
//    "type": 10,
//    "user_id": 1,
//    "subscription_id": 1,
//    "updated_at": 1528030907,
//    "created_at": 1528030907

    @Expose
    @SerializedName("id")
    var id: Int? = null

    @Expose
    @SerializedName("type")
    var type: Int? = null

    @Expose
    @SerializedName("user_id")
    var user_id: Int? = null

    @Expose
    @SerializedName("subscription_id")
    var subscription_id: Int? = null

    @Expose
    @SerializedName("updated_at")
    var updated_at: Int? = null

    @Expose
    @SerializedName("created_at")
    var created_at: Int? = null

}