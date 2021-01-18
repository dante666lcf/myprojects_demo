package kz.app.deliveryapp.mvp.controllers.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.app.deliveryapp.R
import kz.app.deliveryapp.mvp.controllers.viewholders.VHCellNews
import kz.app.deliveryapp.mvp.модели.модель_новости.TNewsItem

class AdapterListNews(
    private val newsItems: ArrayList<TNewsItem>,
    private val onNewsItemClick: (TNewsItem) -> Unit
) : RecyclerView.Adapter<VHCellNews>() {

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): VHCellNews {
        return VHCellNews(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vh_cell_news, parent, false), onNewsItemClick
        )
    }

    override fun onBindViewHolder(holder: VHCellNews, position: Int) {
        holder.render(newsItems[position])
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }
}