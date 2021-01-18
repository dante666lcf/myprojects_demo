package kz.alemtime.alem.support.navigation

import android.os.Parcel
import android.os.Parcelable
import ru.terrakok.cicerone.Router

class ApplicationRouter() : Router(), Parcelable {

    constructor(parcel: Parcel) : this()

    companion object CREATOR : Parcelable.Creator<ApplicationRouter> {
        override fun createFromParcel(parcel: Parcel): ApplicationRouter {
            return ApplicationRouter(parcel)
        }

        override fun newArray(size: Int): Array<ApplicationRouter?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {

    }

}