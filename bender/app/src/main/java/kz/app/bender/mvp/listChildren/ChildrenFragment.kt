package kz.app.bender.mvp.listChildren

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_children.*
import kz.app.bender.R
import kz.app.bender.controllers.adapters.AdapterListChildren
import kz.app.bender.mvp.IndigoMVPFragment
import kz.app.bender.mvp.root.RootPresenter
import kz.app.bender.support.provider.FragmentProvider


class ChildrenFragment : IndigoMVPFragment<ChildrenPresenter>(), ChildrenContract.View {

    private var menuChild: Menu? = null

    //region Companion
    companion object {
        fun newInstance(): ChildrenFragment {
            val fragment = ChildrenFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: ChildrenPresenter

    @ProvidePresenter
    internal fun providesChildrenPresenter(): ChildrenPresenter {
        return ChildrenPresenter(router)
    }

    override fun getPresenter(): ChildrenPresenter {
        return mPresenter
    }
    //endregion

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

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setLayoutResourceId(kz.app.bender.R.layout.fragment_children)
                .setToolbarTitle(getString(R.string.select_child))
                .setHasOptions(true)
    }

    override fun prepareUI() {}

    override fun setChildrenList(adapterListChildrens: AdapterListChildren, spanCount: Int) {
        recyclerView.layoutManager = GridLayoutManager(activity, spanCount)
        recyclerView.adapter = adapterListChildrens
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.drop_menu, menu)
        this.menuItems = menu
        this.menuChild = menu
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.menu_drop_action_exit -> {
                RootPresenter.instance.clearUser()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
        mPresenter.setMenuItemFIO()
    }

    override fun changeFIOinItemMenu(fio: String?) {
        if (menuChild!!.size() != 0) {
            this.menuChild?.getItem(0)!!.title = fio
        }
    }
}