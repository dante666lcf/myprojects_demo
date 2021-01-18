package kz.app.deliveryapp.mvp.controllers.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.vh_cell_hot.view.*
import kz.app.deliveryapp.di.modules.GlideApp
import kz.app.deliveryapp.mvp.модели.модель_акции.THotItem

class VHCellAksii(
    itemView: View,
    private val onHotItemClick: (THotItem) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun render(hotItem: THotItem?) {
        hotItem?.let {

            itemView.vhCellHotTextViewTitle.text = it.title

            GlideApp.with(itemView.context)
                .load(it.urlImg)
                .centerCrop()
                .into(itemView.vhCellHotImageViewLogo)

        }
        itemView.setOnClickListener { onHotItemClick(hotItem!!) }
    }
}