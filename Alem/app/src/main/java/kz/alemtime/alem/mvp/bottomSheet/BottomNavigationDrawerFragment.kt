//package kz.alemtime.alem.mvp.bottomSheet
//
//import android.os.Bundle
//import android.support.design.widget.BottomSheetDialogFragment
//import android.view.Gravity
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import kotlinx.android.synthetic.main.dialog_bottomsheet_menu.*
//import kz.alemtime.alem.R
//import kz.alemtime.alem.models.TProfile
//import kz.alemtime.alem.mvp.main.MainPresenter
//import kz.alemtime.alem.support.stat.ZPrefs
//
//class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.dialog_bottomsheet_menu, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val profile: TProfile? = ZPrefs.getUserProfile(ApplicationMain.getInstance()!!.sharedPreferences)
//
//        tvMenuProfile.text = profile?.username
//
//        navigation_view.setNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.nav_menu_search -> toast("В разработке")
//                R.id.nav_menu_favorites -> toast("В разработке")
//                R.id.nav_menu_profile -> {
//                    dialog.dismiss()
//                    MainPresenter.flowRouter!!.router.navigateTo(Screens.FlowProfile())
//                }
//                R.id.nav_menu_abous_us -> {
//                    dialog.dismiss()
//                    MainPresenter.flowRouter!!.router.navigateTo(Screens.FlowWebView("https://alemtime.kz/app/about"))
//                }
//                R.id.nav_menu_faq ->{
//                    dialog.dismiss()
//                    MainPresenter.flowRouter!!.router.navigateTo(Screens.FlowWebView("https://alemtime.kz/app/faq"))
//                }
//            }
//            true
//        }
//
//        ivMenuExit.setOnClickListener {
//            dialog.dismiss()
//            ZPrefs.logOut(ApplicationMain.getInstance()!!.sharedPreferences)
//            MainPresenter.flowRouter!!.router.newRootScreen(Screens.FlowLogin())
//        }
//    }
//
//    private fun toast(stringToast: String) {
//        val toast = Toast.makeText(activity, stringToast, Toast.LENGTH_SHORT).apply {
//            setGravity(Gravity.BOTTOM, 0, 325)
//            show()
//        }
//    }
//
//}