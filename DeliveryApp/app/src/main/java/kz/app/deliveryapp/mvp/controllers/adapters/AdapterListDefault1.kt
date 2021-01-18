package kz.app.deliveryapp.mvp.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.app.deliveryapp.mvp.controllers.viewholders.VHCellDefault1
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.модели.модель_меню.TMenuList
import java.util.*

class AdapterListDefault1(
    private val defaultItems: ArrayList<TMenuList>,
    private val onDefaultItemClick: (TMenuList) -> Unit
) : RecyclerView.Adapter<VHCellDefault1>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellDefault1 {
        return VHCellDefault1(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_default_1, parent, false), onDefaultItemClick
        )
    }

    override fun onBindViewHolder(holder: VHCellDefault1, position: Int) {
        holder.render(defaultItems[position])
    }

    override fun getItemCount(): Int {
        return defaultItems.size
    }
}
