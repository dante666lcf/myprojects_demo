package kz.alemtime.alem.controllers.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import kz.alemtime.alem.models.otherModels.TLocalities

class VHCellCitiesInRegion(
        itemView: View,
        private val onCiryInRegionClick: (Any) -> Unit)
    : RecyclerView.ViewHolder(itemView) {

    //region UI
    fun render(cityInRegion: TLocalities?) {
        cityInRegion?.let { locality ->
//            itemView.vh_cell_category_post_textview_title.text = postByCategory.title
//
//            itemView.vh_cell_category_post_bottom_textview_date.text = postByCategory.created_at.toString()
//            itemView.vh_cell_category_post_bottom_textview_location.text = postByCategory.locality_name
//            /*TODO: разобраться с этим...*/
//            itemView.vh_cell_category_post_bottom_textview_type.visibility = View.GONE
//
//            /*TODO: изменить placeholder*/
//            GlideApp.with(itemView.context)
//                    .load(postByCategory.photo_big)
//                    .centerCrop()
//                    .placeholder(R.drawable.profile_placeholder_logo)
//                    .into(itemView.vh_cell_category_post_imageview_logo)
//
            itemView.setOnClickListener { onCiryInRegionClick(locality) }
        }
    }
}