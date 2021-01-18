package kz.app.bender.support.navigation.screen;

import android.os.Parcel;
import android.os.Parcelable;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class BenderScreen extends SupportAppScreen implements Parcelable {

    protected BenderScreen() {
    }

    private BenderScreen(Parcel in) {
    }

    public static final Creator<BenderScreen> CREATOR = new Creator<BenderScreen>() {
        @Override
        public BenderScreen createFromParcel(Parcel in) {
            return new BenderScreen(in);
        }

        @Override
        public BenderScreen[] newArray(int size) {
            return new BenderScreen[size];
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
