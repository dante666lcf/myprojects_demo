package kz.alemtime.alem.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.alemtime.alem.R
import kz.alemtime.alem.controllers.viewholders.VHCellPostByCategory
import kz.alemtime.alem.models.otherModels.TPosts
import java.util.*

class AdapterListPostsByCategory(
        private val postByCategory: ArrayList<TPosts>,
        private val onPostByCategoryClick: (TPosts) -> Unit
) : RecyclerView.Adapter<VHCellPostByCategory>() {

    //region Overridden Methods
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellPostByCategory {
        return VHCellPostByCategory(LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_category_posts, parent, false), onPostByCategoryClick)
    }

    override fun onBindViewHolder(holder: VHCellPostByCategory, position: Int) {
        holder.render(postByCategory[position])
    }

    override fun getItemCount(): Int {
        return postByCategory.size
    }
    //endregion
}