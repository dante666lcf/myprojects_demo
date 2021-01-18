package kz.alemtime.alem.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.alemtime.alem.R
import kz.alemtime.alem.controllers.viewholders.VHCellCategoriesType32
import kz.alemtime.alem.models.otherModels.TCategoryType
import java.util.*

class AdapterListCategoriesType32(
        private val categoriesType32: ArrayList<TCategoryType>,
        private val onCategoryTypeClick: (TCategoryType) -> Unit
) : RecyclerView.Adapter<VHCellCategoriesType32>() {

    //region Overridden Methods
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellCategoriesType32 {
        return VHCellCategoriesType32(LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_categories_type_32, parent, false), onCategoryTypeClick)
    }

    override fun onBindViewHolder(holder: VHCellCategoriesType32, position: Int) {
        holder.render(categoriesType32[position])
    }

    override fun getItemCount(): Int {
        return categoriesType32.size
    }
    //endregion
}
