package kz.app.bender.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.app.bender.R
import kz.app.bender.controllers.viewholders.VHCellChildren
import kz.app.bender.models.TChildrenItem
import java.util.*

class AdapterListChildren(
        private val childrenItems: ArrayList<TChildrenItem>,
        private val onChildrenClick: (TChildrenItem) -> Unit,
        private val onCreateObject: (TChildrenItem, byteArray: ByteArray) -> Unit
) : RecyclerView.Adapter<VHCellChildren>() {

    //region Overridden Methods
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellChildren {
        return VHCellChildren(LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_children, parent, false), onChildrenClick, onCreateObject)
    }

    override fun onBindViewHolder(holder: VHCellChildren, position: Int) {
        holder.render(childrenItems[position])
    }

    override fun getItemCount(): Int {
        return childrenItems.size
    }
    //endregion
}
