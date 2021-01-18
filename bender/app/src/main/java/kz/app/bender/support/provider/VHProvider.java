package kz.app.bender.support.provider;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

public interface VHProvider<VH> {
    VH provide(@NonNull ViewGroup parent, int viewType);
}
