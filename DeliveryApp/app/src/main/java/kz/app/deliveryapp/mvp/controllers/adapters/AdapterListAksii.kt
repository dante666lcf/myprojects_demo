package kz.app.deliveryapp.mvp.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.controllers.viewholders.VHCellAksii
import kz.app.deliveryapp.mvp.модели.модель_акции.THotItem

class AdapterListAksii(
    private val hotItems: ArrayList<THotItem>,
    private val onHotItemClick: (THotItem) -> Unit
) : RecyclerView.Adapter<VHCellAksii>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellAksii {
        return VHCellAksii(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_hot, parent, false), onHotItemClick
        )
    }

    override fun onBindViewHolder(holder: VHCellAksii, position: Int) {
        holder.render(hotItems[position])
    }

    override fun getItemCount(): Int {
        return hotItems.size
    }
}