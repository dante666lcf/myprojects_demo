package kz.app.bender.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class TPhotoChild : RealmObject() {

    @PrimaryKey
    var id: String? = null
    var idChild: Int? = null
    var photoId: Int? = null
    var photoBitmap: ByteArray? = null

}