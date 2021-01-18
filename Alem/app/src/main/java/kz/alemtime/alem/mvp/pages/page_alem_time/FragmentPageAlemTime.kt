package kz.alemtime.alem.mvp.pages.page_alem_time

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_page_alemtime.*
import kz.alemtime.alem.R
import kz.alemtime.alem.controllers.adapters.AdapterListCategoriesType32
import kz.alemtime.alem.controllers.adapters.AdapterListPostsByCategory
import kz.alemtime.alem.di.modules.GlideApp
import kz.alemtime.alem.models.otherModels.TPosts
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.support.provider.FragmentProvider

class FragmentPageAlemTime
    : RootMvpAppCompatFragment<FragmentPageAlemTimePresenter>(), FragmentPageAlemTimeContract.View {

    companion object {
        fun newInstance(): FragmentPageAlemTime {
            val fragment = FragmentPageAlemTime()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: FragmentPageAlemTimePresenter

    @ProvidePresenter
    internal fun provideFragmentPageAlemTimePresenter(): FragmentPageAlemTimePresenter {
        return FragmentPageAlemTimePresenter(router)
    }

    override fun getPresenter(): FragmentPageAlemTimePresenter {
        return mPresenter
    }

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider().setLayoutResourceId(R.layout.fragment_page_alemtime)
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroyView() {
        mPresenter.onDestroyView()
        super.onDestroyView()
    }

    override fun prepareUI() {

    }

    override fun showRVTopCategories(adapterListCategoriesType32: AdapterListCategoriesType32) {
        alemtime_rv_top_filter.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        alemtime_rv_top_filter.adapter = adapterListCategoriesType32
    }

    override fun setBigTitleCategory(textCategory: String) {
        alemtime_tv_title_category.text = textCategory
    }

    override fun showRVPostByCategory(adapterListPostsByCategory: AdapterListPostsByCategory) {
        alemtime_rv_category_posts.layoutManager = LinearLayoutManager(activity)
        alemtime_rv_category_posts.adapter = adapterListPostsByCategory
    }

    override fun setWordOfTheDay() {

    }

    override fun setPostHot(postHot: TPosts) {
        alem_time_post_hot_tv_post_description.text = postHot.body
        alem_time_post_hot_tv_post_date.text = postHot.created_at.toString()
        alem_time_post_hot_tv_locality.text = postHot.locality_name

        //TODO: изменить placeholder
        GlideApp.with(context!!)
                .load(postHot.photo_big)
                .centerCrop()
                .placeholder(R.drawable.profile_placeholder_logo)
                .into(alem_time_post_hot_logo)
    }

    override fun showSimpleToast(testToast: String) {
        Toast.makeText(context, testToast, Toast.LENGTH_LONG).show()
    }
}