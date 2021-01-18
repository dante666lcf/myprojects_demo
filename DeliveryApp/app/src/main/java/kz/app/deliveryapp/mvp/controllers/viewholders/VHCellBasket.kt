package kz.app.deliveryapp.mvp.controllers.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.vh_cell_basket_item.view.*
import kz.app.deliveryapp.di.modules.GlideApp
import kz.app.deliveryapp.mvp.модели.модель_еды.TEdaItem

class VHCellBasket(
    itemView: View,
    private val onDeleteItemClick: (TEdaItem, positionItem: Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun render(basketItem: TEdaItem?) {
        basketItem?.let { item ->

            GlideApp.with(itemView.context)
                .load(item.urlImg)
                .centerCrop()
                .into(itemView.basketImageViewLogo)

            itemView.basketTextViewTitle.text = item.title
            itemView.basketTextViewPrice.text = item.price.toString()

            itemView.basketImageViewDeleteFromBasket.setOnClickListener {
                onDeleteItemClick(item, adapterPosition)
            }
        }
    }
}