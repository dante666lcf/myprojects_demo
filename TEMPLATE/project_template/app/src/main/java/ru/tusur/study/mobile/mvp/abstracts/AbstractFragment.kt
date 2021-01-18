package ru.tusur.study.mobile.mvp.abstracts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import moxy.MvpAppCompatFragment
import ru.tusur.study.mobile.mvp.activity.RootActivity

abstract class AbstractFragment<T : AbstractPresenter<*>> : MvpAppCompatFragment(),
    AbstractContract.View {

    //region Connection Between Fragments
//    protected val authStateVM: AuthStateVM by activityViewModels()
    //endregion

    //region Abstract
    protected abstract fun getLayoutResourceId(): Int

    protected abstract fun getPresenter(): T
    //endregion

    //region Overridden methods
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResourceId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        if (isAuthRequired()) {
//            authStateVM.getResult().observe(this.viewLifecycleOwner, Observer {
//                when (it) {
//                    AuthStateVM.AuthState.AUTHENTICATED -> onAuthSuccess()
//                    else -> {
//                        findNavController().navigate(R.id.action_global_loginFragment2)
//                    }
//                }
//            })
//        }
    }
    //endregion

    //region UI
    final override fun showLoading() {
        (activity as? RootActivity)?.showLoading()
    }

    final override fun hideLoading() {
        (activity as? RootActivity)?.hideLoading()
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
//        regularBanner.show(view!!)
    }

    override fun showSuccess(title: String?, message: String?) {
//        val regularBanner = RegularBanner(
//            RegularBanner.Type.SUCCESS,
//            title ?: "Успешно",
//            message ?: "",
//            Gravity.TOP,
//            RegularBanner.Duration.LONG,
//            null
//        )
//        regularBanner.show(view!!)
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
//        regularBanner.show(view!!)
    }

//    override fun showNotification(type: RegularBanner.Type, title: String, description: String, duration: RegularBanner.Duration) {
//        (activity as? RootActivity)?.showNotification(type, title, description, duration)
//    }

    override fun exit() {
        findNavController().popBackStack()
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
//        regularBanner.show(view!!)
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
//        retryDialog.build().show(childFragmentManager, "retryDialog")
    }

    override fun restartActivity() {
        activity?.finish()
        activity?.startActivity(activity?.intent)
    }

    override fun onLogout() {
        (activity as? RootActivity)?.onLogout()
    }
    //endregion

    protected fun showErrorNotification(message: String) {
//        showNotification(RegularBanner.Type.ERROR, getString(R.string.common_error), message, RegularBanner.Duration.LONG)
    }

//    protected open fun isAuthRequired(): Boolean = true // Метод определяющий, нужно ли проверять авторизацию для открытия этого экрана. true - нужно, false - не нужно

//    protected open fun onAuthSuccess() {} // Некоторые методы можно вызвать только после успешной аутентификации. Переопредите метод если есть возникла такая необходимость
}