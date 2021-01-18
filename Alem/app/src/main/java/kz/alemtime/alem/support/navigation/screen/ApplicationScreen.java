package kz.alemtime.alem.support.navigation.screen;

import android.os.Parcel;
import android.os.Parcelable;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class ApplicationScreen extends SupportAppScreen implements Parcelable {

    protected ApplicationScreen() {
    }

    private ApplicationScreen(Parcel in) {
    }

    public static final Creator<ApplicationScreen> CREATOR = new Creator<ApplicationScreen>() {
        @Override
        public ApplicationScreen createFromParcel(Parcel in) {
            return new ApplicationScreen(in);
        }

        @Override
        public ApplicationScreen[] newArray(int size) {
            return new ApplicationScreen[size];
        }
    };

    //region Overridden methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
    //endregion
}
