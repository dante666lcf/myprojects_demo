package kz.alemtime.alem.mvp.main

import android.os.Bundle
import butterknife.ButterKnife
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kz.alemtime.alem.R
import kz.alemtime.alem.support.navigation.ApplicationRouter
import kz.alemtime.alem.support.navigation.RouterProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), MainContract.View, RouterProvider {
    override fun provideTabTopNavRouter(): ApplicationRouter {
        return flowRouter.router
    }

    companion object {
        lateinit var instance: MainActivity
    }

    private lateinit var flowRouter: Cicerone<ApplicationRouter>

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    internal fun providesMainPresenter(): MainPresenter {
        createFlowRouterIfNecessary()
        return MainPresenter(flowRouter.router, supportFragmentManager)
    }

    override fun provideRouter(): ApplicationRouter {
        return flowRouter.router
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        instance = this
        super.onCreate(savedInstanceState)
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

    override fun prepareUI() {

    }

    override fun showRequestError(throwable: Throwable?) {
    }

    override fun showResponseError(responseResultCode: Int, responseResultMessage: String?) {
    }

    private fun createFlowRouterIfNecessary() {
        flowRouter = Cicerone.create(ApplicationRouter())
        flowRouter.navigatorHolder.setNavigator(SupportAppNavigator(this, supportFragmentManager, R.id.flContainer))
    }

}
