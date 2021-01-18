package kz.alemtime.alem.controllers.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.vh_cell_categories_type_32.view.*
import kz.alemtime.alem.models.otherModels.TCategoryType

class VHCellCategoriesType32(
        itemView: View,
        private val onCategoryTypeClick: (TCategoryType) -> Unit)
    : RecyclerView.ViewHolder(itemView) {

    //region UI
    fun render(category: TCategoryType?) {
        category?.let {
            itemView.vh_cell_textview_category.text = category.name
            itemView.setOnClickListener { onCategoryTypeClick(category) }
        }
    }
}