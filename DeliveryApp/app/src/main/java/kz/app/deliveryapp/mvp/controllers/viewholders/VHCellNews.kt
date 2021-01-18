package kz.app.deliveryapp.mvp.controllers.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.vh_cell_news.view.*
import kz.app.deliveryapp.di.modules.GlideApp
import kz.app.deliveryapp.mvp.модели.модель_новости.TNewsItem

class VHCellNews(
    itemView: View,
    private val onNewsItemClick: (TNewsItem) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun render(newsItem: TNewsItem?) {
        newsItem?.let {

            itemView.vhCellNewsTextViewTitle.text = it.title
            itemView.vhCellNewsTextViewDate.text = it.date

            GlideApp.with(itemView.context)
                .load(it.urlImg)
                .centerCrop()
                .into(itemView.vhCellNewsImageViewLogo)

        }
        itemView.setOnClickListener { onNewsItemClick(newsItem!!) }
    }
}