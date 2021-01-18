package kz.app.deliveryapp.mvp.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.controllers.viewholders.VHCellBasket
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem

class AdapterListBasket(
    private val basketItems: ArrayList<TEdaItem>,
    private val onDeleteItemClick: (TEdaItem, positionItem: Int) -> Unit
) : RecyclerView.Adapter<VHCellBasket>() {
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellBasket {
        return VHCellBasket(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_basket_item, parent, false), onDeleteItemClick
        )
    }

    override fun onBindViewHolder(holder: VHCellBasket, position: Int) {
        holder.render(basketItems[position])
    }

    override fun getItemCount(): Int {
        return basketItems.size
    }
}