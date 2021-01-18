package kz.alemtime.alem.models.otherModels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class TPosts : Serializable {

//    "id": 17,
//    "type": 1,
//    "status": 20,
//    "author_id": 3,
//    "category_id": 29,
//    "locality_id": 2,
//    "title": "Первый промоушн JFC состоится в Жетысу",
//    "title_translit": "",
//    "about_short": "",
//    "body": "<p>В прошлом году, спортсмены по смешанным единоборствам Алматинской области принялись за создание аналогового варианта по профессиональным турнирам MMA- UFC. Спустя время, мечта воплотилась в реальность, и 17 декабря текущего года впервые в истории области состоится турнир JFС- JetysuFightingChampionship.</p><p>В одном из заведений города Талдыкорган соберутся представители 10- ти бойцовских клубов страны. Всего в общей сложности состоится 14 боев, 13 из которых мужские и 1 женский.</p><p>«17 декабря в комплексе «Меруерт» состоится турнир по ММА. Впервые пройдет при организации, созданного нами промоушенаJetysuFightingChampionship. Созданы все необходимые условия для честного и зрелищного боя, всего в общей сложности 3 раунда. Примут участие перспективные и талантливые спортсмены, мастера спорта по всем весовым категориям», - поделился организатор проекта Евгений Воронин.</p><p>Цель данного проекта - развитие спорта среди молодёжи и предоставление возможности для продвижения карьеры бойца на профессиональном уровне.</p><p>Участники турнира поборются за денежное вознаграждение и рейтинги. Ведь, помимо гонораров, организаторы предоставляют бойцам по смешанным единоборствам площадку для развития. Показав хорошие результаты, у них есть возможность быть замеченными одним из лучших клубов ММА в Евразии, «AlashPride».</p><p>Судьями состязания выступят представители Федерации грэпплингаАлматинской области.</p><p>Любителей и ценителей боевых искусств, организаторы приглашают посмотреть и поболеть за своих фаворитов.</p>",
//    "photo_id": 57,
//    "views": 0,
//    "created_at": 1548327974,
//    "updated_at": 1548327974,
//    "locality": {
//        "id": 2,
//        "type": 20,
//        "status": 20,
//        "parent_id": 16,
//        "name": "Талгар",
//        "name_translit": "talgar",
//        "name_second": "",
//        "about_short": "Талга́р (каз. Талғар, /tɑlˈɣɑr/) — город в Казахстане, центр Талгарского района Алматинской области. Расположен на северных склонах Заилийского Алатау, в 25 км к востоку от Алматы.",
//        "about_detailed": "<p>Город Талгар расположен в центре евразийского континента, на юго-востоке Республики Казахстан, он занимает площадь 1808 га и находится на высоте 1000—1300 метров над уровнем моря. Талгар находится на одной параллели с такими известными городами как <a href=\"https://ru.wikipedia.org/wiki/%D0%93%D0%B0%D0%B3%D1%80%D1%8B\">Гагры</a> и <a href=\"https://ru.wikipedia.org/wiki/%D0%92%D0%BB%D0%B0%D0%B4%D0%B8%D0%B2%D0%BE%D1%81%D1%82%D0%BE%D0%BA\">Владивосток</a>. Через город проходит автотранспортная магистраль республиканского значения, соединяющая г. Талгар с г. Алма-Ата протяженностью 25&nbsp;км. Сообщение города с другими городами осуществляется автомобильным, железнодорожным, воздушным транспортом через г. Алма-Ата. Кадастровый код 057.</p>",
//        "about_article_id": null,
//        "photo_id": 31,
//        "gallery_id": null,
//        "population": 45521,
//        "founded_at": null,
//        "geo_longitude": null,
//        "geo_latitude": null,
//        "geo_altitude": null,
//        "created_at": 1548140818,
//        "updated_at": 1548272938
//    },
//    "photo_big": "https://alemtime.kz/images/post/big/57.jpeg",
//    "photo_small": "https://alemtime.kz/images/post/small/57.jpeg",
//    "photo_thumbnail": "https://alemtime.kz/images/post/thumbnail/57.jpeg",
//    "locality_name": "Талгар",
//    "author_full_name": "  ",
//    "author_name": " ",
//    "author_short_name": " "

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
    @SerializedName("author_id")
    var author_id: Int? = null

    @Expose
    @SerializedName("category_id")
    var category_id: Int? = null

    @Expose
    @SerializedName("locality_id")
    var locality_id: Int? = null

    @Expose
    @SerializedName("title")
    var title: String? = null

    @Expose
    @SerializedName("title_translit")
    var title_translit: String? = null

    @Expose
    @SerializedName("about_short")
    var about_short: String? = null

    @Expose
    @SerializedName("body")
    var body: String? = null

    @Expose
    @SerializedName("photo_id")
    var photo_id: Int? = null

    @Expose
    @SerializedName("views")
    var views: Int? = null

    @Expose
    @SerializedName("created_at")
    var created_at: Long? = null

    @Expose
    @SerializedName("updated_at")
    var updated_at: Long? = null

    @Expose
    @SerializedName("photo_big")
    var photo_big: String? = null

    @Expose
    @SerializedName("photo_small")
    var photo_small: String? = null

    @Expose
    @SerializedName("photo_thumbnail")
    var photo_thumbnail: String? = null

    @Expose
    @SerializedName("locality_name")
    var locality_name: String? = null

    @Expose
    @SerializedName("author_full_name")
    var author_full_name: String? = null

    @Expose
    @SerializedName("author_name")
    var author_name: String? = null

    @Expose
    @SerializedName("author_short_name")
    var author_short_name: String? = null

}