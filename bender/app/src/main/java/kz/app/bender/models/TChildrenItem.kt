package kz.app.bender.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TChildrenItem : Serializable {

    @Expose
    @SerializedName("Id")
    var id: Int = 0

    @Expose
    @SerializedName("PhotoId")
    var photoId: Int? = 0

    @Expose
    @SerializedName("person")
    var personChild: TPersonChild? = null

    @Expose
    @SerializedName("pupilRepresentative")
    var pupilRepresentative: ArrayList<TPersonParent>? = null

}