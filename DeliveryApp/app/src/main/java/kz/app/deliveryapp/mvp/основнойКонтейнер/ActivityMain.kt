package kz.app.deliveryapp.mvp.основнойКонтейнер

import android.os.Bundle
import butterknife.ButterKnife
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kz.app.deliveryapp.R
import kz.app.deliveryapp.support.навигация.BenderRouter
import kz.app.deliveryapp.support.навигация.RouterProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class ActivityMain : MvpAppCompatActivity(), RootContract.View, RouterProvider {

    //region Companion Object
    companion object {
        //region Static
        lateinit var instance: ActivityMain
        //endregion
    }
    //endregion

    //region Vars
    private lateinit var flowRouter: Cicerone<BenderRouter>
    //endregion

    //region DI
    @InjectPresenter
    lateinit var presenter: RootPresenter

    @ProvidePresenter
    internal fun providesRootPresenter(): RootPresenter {
        createFlowRouterIfNecessary()
        return RootPresenter(flowRouter.router, supportFragmentManager)
    }
    //endregion

    //region Overrides
    override fun provideRouter(): BenderRouter {
        return flowRouter.router
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        instance = this
        super.onCreate(null)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        presenter.onCreateView(null, null)
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        createFlowRouterIfNecessary()
        presenter.onResume(flowRouter.router, supportFragmentManager)
    }

    override fun onPause() {
        flowRouter.navigatorHolder.removeNavigator()
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        presenter.onDestroyView()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (presenter != null)
            presenter.navigateBackVisibleFragment()
        else
            super.onBackPressed()
    }
    //endregion

    //region UI
    override fun prepareUI() {

    }

    override fun showRequestError(throwable: Throwable?) {

    }

    override fun showResponseError(responseResultCode: Int, responseResultMessage: String?) {

    }
    //endregion

    //region Support
    private fun createFlowRouterIfNecessary() {
        flowRouter = Cicerone.create(BenderRouter())
        flowRouter.navigatorHolder.setNavigator(SupportAppNavigator(this, supportFragmentManager, R.id.flContainer))
    }
    //endregion
}
