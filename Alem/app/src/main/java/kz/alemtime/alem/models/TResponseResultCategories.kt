package kz.alemtime.alem.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TResponseResultCategories : Serializable {

//    "id": 1,
//    "parent_id": 0,
//    "status": 20,
//    "type": 8,
//    "locality_id": null,
//    "name": "Бесік той",
//    "name_translit": "besik-toi",
//    "about_short": "Бала туғанда алғашқы жасалатын той",
//    "about_detailed": "Бесікке салу — традиционный казахский  обряд, связанный с рождением ребенка. Это торжественное мероприятие устраивают, когда младенца первый раз кладут в «Бесік» - колыбель-качалку. У казахов «Бесік» считается золотым гнездом младенца, и обряд «Бесікке салу» - является одним из самых значимых и почитаемых. Приглашаются гости, накрывается праздничный дастархан, поэтому обряд «Бесікке салу» еще называют «Бесік той». Красивая колыбель, новые красивые одеяльца, подушки, перинки, ленточки и завязки — все это смотрится очень привлекательно и нарядно. По обычаю, «Бесік» ребенку готовит и привозит бабушка, со стороны матери. Первый раз уложить ребенка в колыбель поручают образцовой, опытной, имеющей большой авторитет бабушке или женщине. Уложить младенца в «Бесік» в первый раз очень почетно.  По казахскому поверью, «Бесік» сначала окуривают дымом, изгоняя злых духов, затем проводят интересный обряд - «Тыштырма». Для этого, через отверстие для горшочка в днище колыбели, пропускают конфеты, курт, сладости приговаривая: «Тышты! Тышты!». Это поверье означает, что родившийся ребенок принесет в дом благополучие и богатство. Гости стараются поймать сладости и раздают детям.",
//    "photo_id": 105,
//    "created_at": 1522866659,
//    "updated_at": 1524452975

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
    @SerializedName("about_detailed")
    var about_detailed: String? = null

    @Expose
    @SerializedName("photo_id")
    var photo_id: Int? = null

    @Expose
    @SerializedName("created_at")
    var created_at: Long? = null

    @Expose
    @SerializedName("updated_at")
    var updated_at: Long? = null

}