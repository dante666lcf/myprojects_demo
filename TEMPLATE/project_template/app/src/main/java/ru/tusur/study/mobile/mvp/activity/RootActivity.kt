package ru.tusur.study.mobile.mvp.activity

import android.os.Bundle
import android.webkit.CookieSyncManager
import androidx.navigation.Navigation
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.tusur.study.mobile.R

class RootActivity : MvpAppCompatActivity(), RootContract.View {


    @InjectPresenter
    internal lateinit var mPresenter: RootPresenter

    @ProvidePresenter
    internal fun providesRootPresenter(): RootPresenter {
        return RootPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)

//        dialogLoading = ProgressDialogFragment()
//        setupBottomNavigationView()
//        setupViewModels()
    }

    override fun onResume() {
        super.onResume()
//        setupConnectivityReceiver()
        mPresenter.onResumeViewState()
    }

    override fun onPause() {
        mPresenter.onPauseViewState()
        super.onPause()
    }


    override fun prepareUI() {

    }

    override fun showLoading() {
//        if (dialogLoading?.isAdded != true) {
//            dialogLoading?.showIfNotAdded(supportFragmentManager, "showProgressDialog")
//        }
    }

    override fun hideLoading() {
//        dialogLoading?.dismiss()
    }

    override fun showInfo(title: String?, message: String?) {
//        val regularBanner = RegularBanner(
//            RegularBanner.Type.INFO,
//            title ?: "Инфо",
//            message ?: "",
//            Gravity.TOP,
//            RegularBanner.Duration.LONG,
//            null
//        )
//        regularBanner.show(this)
    }

    override fun showSuccess(title: String?, message: String?) {
//        val regularBanner = RegularBanner(
//            RegularBanner.Type.SUCCESS,
//            title ?: getString(R.string.success),
//            message ?: "",
//            Gravity.TOP,
//            RegularBanner.Duration.LONG,
//            null
//        )
//        regularBanner.show(this)
    }

    override fun showWarning(title: String?, message: String?) {
//        val regularBanner = RegularBanner(
//            RegularBanner.Type.INFO,
//            title ?: "Предупреждение",
//            message ?: "",
//            Gravity.TOP,
//            RegularBanner.Duration.SHORT,
//            null
//        )
//        regularBanner.show(this)
    }

    override fun exit() {
        Navigation.findNavController(this, R.id.navHostFragment).popBackStack()
    }

    override fun showNoConnectionError() {
//        showError(getString(R.string.common_error_no_connection), getString(R.string.common_error_could_not_connect_to_server))
    }

    override fun showConnectionError() {
//        showError(getString(R.string.common_error_of_connection), getString(R.string.common_error_could_not_connect_to_server))
    }

    override fun showNetworkResponseError(message: String?) {
//        showError(getString(R.string.common_error_of_server), message ?: "")
    }

    override fun showNullResponseError() {
//        showError(getString(R.string.common_error_of_server), getString(R.string.common_no_data))
    }

    override fun showBackendResponseError(backendErrorCode: Int, message: String?) {
//        val title = when (backendErrorCode) {
//            in 500..599 -> getString(R.string.common_error_of_server)
//            else -> getString(R.string.common_error)
//        }
//        showError(title, message ?: "")
    }

    override fun showActivityNotFoundError() {
//        showError(getString(R.string.common_error), getString(R.string.common_error_app_not_found))
    }

    override fun showError(title: String?, message: String?) {
//        val regularBanner = RegularBanner(
//            RegularBanner.Type.ERROR,
//            title ?: getString(R.string.common_error),
//            message ?: "",
//            Gravity.TOP,
//            RegularBanner.Duration.LONG,
//            null
//        )
//        regularBanner.show(this)
    }

    override fun showRetryDialog(throwable: Throwable, retryAction: () -> Unit) {
//        val title = when (throwable) {
//            is UnknownHostException -> {
//                getString(R.string.common_error_no_connection)
//            }
//            is NetworkConnectionException -> {
//                getString(R.string.common_error_of_connection)
//            }
//            else -> {
//                getString(R.string.common_error)
//            }
//        }
//        val retryDialog = RegularDialog.Builder()
//            .setTitle(title)
//            .setDescription(getString(R.string.common_try_again))
//            .setPositiveButton(getString(R.string.common_ok), retryAction)
//            .setNegativeButton(getString(R.string.common_cancel)) {}
//
//        retryDialog.build().show(supportFragmentManager, "retryDialog")
    }

    override fun restartActivity() {
        finish()
        startActivity(intent)
    }

    override fun onLogout() {
        CookieSyncManager.createInstance(this)
        mPresenter.logout()
    }
}
