package kz.alemtime.alem.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.alemtime.alem.R
import kz.alemtime.alem.controllers.viewholders.VHCellCategoriesType32
import kz.alemtime.alem.controllers.viewholders.VHCellCitiesInRegion
import kz.alemtime.alem.models.otherModels.TCategoryType
import kz.alemtime.alem.models.otherModels.TLocalities
import java.util.*

class AdapterListCitiesInRegion(
        private val localitiesArray: ArrayList<TLocalities>,
        private val onCiryInRegionClick: (Any) -> Unit
) : RecyclerView.Adapter<VHCellCitiesInRegion>() {

    //region Overridden Methods
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellCitiesInRegion {
        return VHCellCitiesInRegion(LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_localities, parent, false), onCiryInRegionClick)
    }

    override fun onBindViewHolder(holder: VHCellCitiesInRegion, position: Int) {
        holder.render(localitiesArray[position])
    }

    override fun getItemCount(): Int {
        return localitiesArray.size
    }
    //endregion
}