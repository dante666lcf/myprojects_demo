package kz.app.bender.mvp.root

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.InjectViewState
import io.realm.Realm
import io.realm.RealmResults
import kz.app.bender.models.TPhotoChild
import kz.app.bender.mvp.AbstractPresenter
import kz.app.bender.mvp.IndigoMVPFragment
import kz.app.bender.mvp.tabsNavigation.FlowFragmentMain
import kz.app.bender.support.navigation.BenderRouter
import kz.app.bender.support.navigation.Screens
import ru.terrakok.cicerone.Screen
import java.io.Serializable

@InjectViewState
class RootPresenter(flowRouter: BenderRouter,
                    private var fragmentManager: FragmentManager?)
    : AbstractPresenter<RootContract.View>(flowRouter), RootContract.Presenter, Serializable {

    companion object {
        //region Static
        lateinit var instance: RootPresenter
        private val modelRoot: RootContract.Model = RootModel()
        //endregion
    }

    //region Getters
    val flowRouter: BenderRouter
        get() = router

    private val visibleFragment: Fragment?
        get() {
            var fragmentToExit: Fragment? = null
            var currentFlowFragment: Fragment? = null
            var currentTabsFragment: Fragment? = null

            for (flowFragment in fragmentManager!!.fragments) {
                if (flowFragment.isVisible) {
                    currentFlowFragment = flowFragment
                    fragmentToExit = flowFragment
                }
            }

            if (currentFlowFragment is FlowFragmentMain) {
                for (tabsFragment in currentFlowFragment.childFragmentManager.fragments) {
                    if (tabsFragment.isVisible) {
                        currentTabsFragment = tabsFragment
                        fragmentToExit = tabsFragment
                        break
                    }
                }
                if (currentTabsFragment != null) {
                    for (tabFragment in currentTabsFragment.childFragmentManager.fragments) {
                        if (tabFragment.isVisible) {
                            fragmentToExit = tabFragment
                            break
                        }
                    }
                }
            }
            return fragmentToExit
        }

    init {
        instance = this
    }
    //endregion

    //region Overridden methods
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.getFlowTabsNavigation())
    }

    fun onResume(router: BenderRouter, fragmentManager: FragmentManager) {
        super.onResume(router)
        this.fragmentManager = fragmentManager
    }
    //endregion

    //region Navigation
    fun flowNavigateTo(screen: Screen) {
        router.navigateTo(screen)
    }

    fun navigateBackVisibleFragment() {
        val fragmentToExit = visibleFragment
        if (fragmentToExit is IndigoMVPFragment<*>) {
            val indigoMvpFragmentToExit = fragmentToExit as IndigoMVPFragment<*>?
            indigoMvpFragmentToExit!!.exit()
        }
    }
    //endregion

    fun clearUser() {
        modelRoot.clearUser()
        val realm: Realm = Realm.getDefaultInstance()
        realm.executeTransaction { realmExecute ->
            val result: RealmResults<TPhotoChild> = realmExecute.where(TPhotoChild::class.java).findAll()
            result.deleteAllFromRealm()
        }
        realm.close()
        router.newRootScreen(Screens.getFlowTabsNavigation())
    }
}
