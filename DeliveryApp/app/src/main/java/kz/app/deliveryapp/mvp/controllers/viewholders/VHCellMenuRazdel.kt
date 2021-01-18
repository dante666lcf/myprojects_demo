package kz.app.deliveryapp.mvp.controllers.viewholders

import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.vh_cell_menu_razdel.view.*
import kz.app.deliveryapp.R
import kz.app.deliveryapp.di.modules.GlideApp
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem


class VHCellMenuRazdel(
    itemView: View,
    private val onEdaItemClick: (TEdaItem) -> Unit,
    private val onFavoritesClick: (TEdaItem) -> Unit,
    private val onAddBasketClick: (TEdaItem) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun render(edaItem: TEdaItem?) {
        edaItem?.let {
            itemView.menuRazdelTextViewTitle.text = it.title
            itemView.menuRazdelTextViewDescription.text = it.description
            itemView.menuRazdelTextViewPrice.text =
                itemView.context.getString(R.string.price_with_kzt, it.price.toString())

            GlideApp.with(itemView.context)
                .load(it.urlImg)
                .centerCrop()
                .into(itemView.menuRazdelImageViewLogo)

        }
        itemView.setOnClickListener { onEdaItemClick(edaItem!!) }
        itemView.menuRazdelImageViewOptionsMenu.setOnClickListener {
            val popup = PopupMenu(itemView.context, itemView.menuRazdelImageViewOptionsMenu)
            popup.inflate(R.menu.options_menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.options_menu_add_to_basket -> {
                        onAddBasketClick(edaItem!!)
                        true
                    }
                    R.id.options_menu_add_to_favorites -> {
                        onFavoritesClick(edaItem!!)
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }
}