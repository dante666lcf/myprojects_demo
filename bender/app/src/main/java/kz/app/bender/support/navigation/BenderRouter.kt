package kz.app.bender.support.navigation

import android.os.Parcel
import android.os.Parcelable
import ru.terrakok.cicerone.Router

class BenderRouter() : Router(), Parcelable {

    constructor(parcel: Parcel) : this()

    companion object CREATOR : Parcelable.Creator<BenderRouter> {
        override fun createFromParcel(parcel: Parcel): BenderRouter {
            return BenderRouter(parcel)
        }

        override fun newArray(size: Int): Array<BenderRouter?> {
            return arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {

    }

}