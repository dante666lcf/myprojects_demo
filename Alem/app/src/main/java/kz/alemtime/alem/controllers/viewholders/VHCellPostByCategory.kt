package kz.alemtime.alem.controllers.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.vh_cell_category_posts.view.*
import kz.alemtime.alem.R
import kz.alemtime.alem.di.modules.GlideApp
import kz.alemtime.alem.models.otherModels.TPosts

class VHCellPostByCategory(
        itemView: View,
        private val onPostByCategoryClick: (TPosts) -> Unit)
    : RecyclerView.ViewHolder(itemView) {

    //region UI
    fun render(postByCategory: TPosts?) {
        postByCategory?.let {
            itemView.vh_cell_category_post_textview_title.text = postByCategory.title

            itemView.vh_cell_category_post_bottom_textview_date.text = postByCategory.created_at.toString()
            itemView.vh_cell_category_post_bottom_textview_location.text = postByCategory.locality_name
            /*TODO: разобраться с этим...*/
            itemView.vh_cell_category_post_bottom_textview_type.visibility = View.GONE

            /*TODO: изменить placeholder*/
            GlideApp.with(itemView.context)
                    .load(postByCategory.photo_big)
                    .centerCrop()
                    .placeholder(R.drawable.profile_placeholder_logo)
                    .into(itemView.vh_cell_category_post_imageview_logo)

            itemView.setOnClickListener { onPostByCategoryClick(postByCategory) }
        }
    }
}