package kz.alemtime.alem.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TResponseResultLocalities: Serializable {

//    "id": 1,
//    "type": 10,
//    "parent_id": 22,
//    "name": "Тургень",
//    "name_translit": "selo-turgen",
//    "name_second": "Михайловское",
//    "about_short": "Известный в Казахстане район виноградарства и виноделия",
//    "about_article_id": null,
//    "photo_id": 108,
//    "gallery_id": null,
//    "population": 12116,
//    "founded_at": "1864 г",
//    "geo_longitude": "",      TODO: no
//    "geo_latitude": null,     TODO: no
//    "geo_altitude": null,     TODO: no
//    "created_at": "Mar 31, 2018",
//    "updated_at": "May 28, 2018"

    @Expose
    @SerializedName("id")
    var id: Int? = null

    @Expose
    @SerializedName("type")
    var type: Int? = null

    @Expose
    @SerializedName("parent_id")
    var parent_id: Int? = null

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("name_translit")
    var name_translit: String? = null

    @Expose
    @SerializedName("name_second")
    var name_second: String? = null

    @Expose
    @SerializedName("about_short")
    var about_short: String? = null

    @Expose
    @SerializedName("about_article_id")
    var about_article_id: Int? = null

    @Expose
    @SerializedName("photo_id")
    var photo_id: Int? = null

    @Expose
    @SerializedName("gallery_id")
    var gallery_id: Int? = null

    @Expose
    @SerializedName("population")
    var population: Int? = null

    @Expose
    @SerializedName("founded_at")
    var founded_at: String? = null

    @Expose
    @SerializedName("created_at")
    var created_at: String? = null

    @Expose
    @SerializedName("updated_at")
    var updated_at: String? = null

}