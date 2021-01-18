package kz.alemtime.alem.models.otherModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TCategoryType : Serializable {

    /*EXAMPLE*/
//    "id": 25,
//    "parent_id": 0,
//    "status": 20,
//    "type": 32,
//    "locality_id": null,
//    "name": "Әлем",
//    "name_translit": "",
//    "about_short": "",
//    "photo_id": 49,
//    "created_at": "24 янв. 2019 г.",
//    "updated_at": "14 февр. 2019 г.",
//    "sort": 9

    @Expose
    @SerializedName("id")
    var id: Int? = null

    @Expose
    @SerializedName("parent_id")
    var parent_id: Int? = null

    @Expose
    @SerializedName("status")
    var status: Int? = null

    @Expose
    @SerializedName("type")
    var type: Int? = null

    @Expose
    @SerializedName("locality_id")
    var locality_id: Int? = null

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("name_translit")
    var name_translit: String? = null

    @Expose
    @SerializedName("about_short")
    var about_short: String? = null

    @Expose
    @SerializedName("photo_id")
    var photo_id: Int? = null

    @Expose
    @SerializedName("created_at")
    var created_at: String? = null

    @Expose
    @SerializedName("updated_at")
    var updated_at: String? = null

    @Expose
    @SerializedName("sort")
    var sort: Int? = null

}