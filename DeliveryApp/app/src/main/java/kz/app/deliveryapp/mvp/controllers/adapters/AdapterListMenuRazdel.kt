package kz.app.deliveryapp.mvp.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.controllers.viewholders.VHCellMenuRazdel
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem

class AdapterListMenuRazdel(
    private val edaItems: ArrayList<TEdaItem>,
    private val onEdaItemClick: (TEdaItem) -> Unit,
    private val onFavoritesClick: (TEdaItem) -> Unit,
    private val onAddBasketClick: (TEdaItem) -> Unit
) : RecyclerView.Adapter<VHCellMenuRazdel>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellMenuRazdel {
        return VHCellMenuRazdel(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_menu_razdel, parent, false),
            onEdaItemClick,
            onFavoritesClick,
            onAddBasketClick
        )
    }

    override fun onBindViewHolder(holder: VHCellMenuRazdel, position: Int) {
        holder.render(edaItems[position])
    }

    override fun getItemCount(): Int {
        return edaItems.size
    }
}