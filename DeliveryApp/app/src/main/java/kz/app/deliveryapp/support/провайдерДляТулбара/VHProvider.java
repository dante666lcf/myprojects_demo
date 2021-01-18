package kz.app.deliveryapp.support.провайдерДляТулбара;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

public interface VHProvider<VH> {
    VH provide(@NonNull ViewGroup parent, int viewType);
}
