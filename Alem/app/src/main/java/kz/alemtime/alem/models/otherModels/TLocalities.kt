package kz.alemtime.alem.models.otherModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TLocalities {

    /*TODO: добавить и узнать что они значат.*/
//    "about_article_id": null,
//    "founded_at": null,
//    "geo_longitude": null,
//    "geo_latitude": null,
//    "geo_altitude": null,
//    "sort": null,

    @Expose
    @SerializedName("id")
    var id: Int? = null

    @Expose
    @SerializedName("type")
    var type: Int? = null

    @Expose
    @SerializedName("status")
    var status: Int? = null

    @Expose
    @SerializedName("parent_id")
    var parentId: Int? = null

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("name_translit")
    var nameTranslit: String? = null

    @Expose
    @SerializedName("name_second")
    var nameSecond: String? = null

    @Expose
    @SerializedName("about_short")
    var aboutShort: String? = null

    @Expose
    @SerializedName("about_detailed")
    var aboutDetailed: String? = null

    @Expose
    @SerializedName("about_article_id")
    var aboutArticleId: String? = null

    @Expose
    @SerializedName("photo_id")
    var photoId: Int? = null

    @Expose
    @SerializedName("gallery_id")
    var galleryId: Int? = null

    @Expose
    @SerializedName("population")
    var population: Int? = null

    @Expose
    @SerializedName("created_at")
    var createdAt: Long? = null

    @Expose
    @SerializedName("updated_at")
    var updatedAt: Long? = null

    @Expose
    @SerializedName("photo_big")
    var photoBig: Long? = null

    @Expose
    @SerializedName("photo_small")
    var photoSmall: Long? = null

    @Expose
    @SerializedName("photo_thumbnail")
    var photoThumbnail: Long? = null

}