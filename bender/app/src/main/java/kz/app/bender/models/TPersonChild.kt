package kz.app.bender.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TPersonChild : Serializable {

    @Expose
    @SerializedName("Id")
    var id: Int? = 0

    @Expose
    @SerializedName("Iin")
    var iin: Long? = 0

    @Expose
    @SerializedName("LastName")
    var lastName: String? = null

    @Expose
    @SerializedName("FirstName")
    var firstName: String? = null

    @Expose
    @SerializedName("MiddleName")
    var middleName: String? = null

    @Expose
    @SerializedName("Gender")
    var gender: String? = null

    @Expose
    @SerializedName("Age")
    var age: String? = null

}