package kz.app.deliveryapp.mvp.основнойКонтейнер

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.arellomobile.mvp.InjectViewState
import kz.app.deliveryapp.mvp.AbstractPresenter
import kz.app.deliveryapp.mvp.RootMvpAppCompatFragment
import kz.app.deliveryapp.mvp.tabsNavigation.FlowFragmentMain
import kz.app.deliveryapp.support.навигация.BenderRouter
import kz.app.deliveryapp.support.навигация.Screens
import ru.terrakok.cicerone.Screen
import java.io.Serializable

@InjectViewState
class RootPresenter(
    flowRouter: BenderRouter,
    private var fragmentManager: FragmentManager?
) : AbstractPresenter<RootContract.View>(flowRouter), RootContract.Presenter, Serializable {

    companion object {
        lateinit var instance: RootPresenter
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
        if (fragmentToExit is RootMvpAppCompatFragment<*>) {
            val indigoMvpFragmentToExit = fragmentToExit as RootMvpAppCompatFragment<*>?
            indigoMvpFragmentToExit!!.exit()
        }
    }
    //endregion

    /*TODO: если человек залогинился, эта функция удаляет все данные с кэша*/
    fun clearUser() {
//        modelRoot.clearUser()
//        val realm: Realm = Realm.getDefaultInstance()
//        realm.executeTransaction { realmExecute ->
//            val result: RealmResults<TPhotoChild> = realmExecute.where(TPhotoChild::class.java).findAll()
//            result.deleteAllFromRealm()
//        }
//        realm.close()
//        router.newRootScreen(Screens.getFlowTabsNavigation())
    }
}
