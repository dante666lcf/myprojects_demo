package kz.alemtime.alem.mvp.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.InjectViewState
import kz.alemtime.alem.mvp.AbstractPresenter
import kz.alemtime.alem.mvp.RootMvpAppCompatFragment
import kz.alemtime.alem.mvp.tabsNavigation.FlowFragmentMain
import kz.alemtime.alem.support.navigation.ApplicationRouter
import kz.alemtime.alem.support.navigation.Screens
import kz.alemtime.alem.support.stat.ZPrefs
import ru.terrakok.cicerone.Screen
import java.io.Serializable

@InjectViewState
class MainPresenter(
        flowRouter: ApplicationRouter,
        private var fragmentManager: FragmentManager?
) : AbstractPresenter<MainContract.View>(flowRouter), MainContract.Presenter, Serializable {

    companion object {
        lateinit var instance: MainPresenter
        private val modelMain: MainContract.Model = MainModel()
    }

    //region Getters
    val flowRouter: ApplicationRouter
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
        if (ZPrefs.getUserAuthToken() != null) {
            router.newRootScreen(Screens.getFlowTabsNavigation())
        } else {
            router.newRootScreen(Screens.getFlowLogin())
        }
    }

    fun onResume(router: ApplicationRouter, fragmentManager: FragmentManager) {
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
        if (fragmentToExit is RootMvpAppCompatFragment<*>) {
            val indigoMvpFragmentToExit = fragmentToExit as RootMvpAppCompatFragment<*>?
            indigoMvpFragmentToExit!!.exit()
        }
    }
    //endregion
}
