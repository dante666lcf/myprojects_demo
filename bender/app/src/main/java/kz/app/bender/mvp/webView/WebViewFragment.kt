package kz.app.bender.mvp.webView

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_webview.*
import kz.app.bender.R
import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.IndigoMVPFragment
import kz.app.bender.mvp.root.RootContract
import kz.app.bender.mvp.root.RootModel
import kz.app.bender.support.Config
import kz.app.bender.support.provider.FragmentProvider
import kz.app.bender.support.threads.withDefaultSchedulers


class WebViewFragment : IndigoMVPFragment<WebViewFragmentPresenter>(), WebViewFragmentView {

    private val modelRoot: RootContract.Model = RootModel()
    private var stringUrl: String? = null

    //region Companion
    companion object {
        fun newInstance(stringUrl: String): WebViewFragment {
            val fragment = WebViewFragment()
            val args = Bundle()
            args.putString("STRING_URL", stringUrl)
            fragment.arguments = args
            return fragment
        }
    }
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: WebViewFragmentPresenter

    @ProvidePresenter
    internal fun providesWebViewFragmentPresenter(): WebViewFragmentPresenter {
        return WebViewFragmentPresenter(router)
    }

    override fun getPresenter(): WebViewFragmentPresenter {
        return mPresenter
    }
    //endregion

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setToolbarTitle("")
                .setLayoutResourceId(R.layout.fragment_webview)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun prepareUI() {
        bottomSheetWebView.settings.loadsImagesAutomatically = true
        bottomSheetWebView.settings.javaScriptEnabled = true
        bottomSheetWebView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        bottomSheetWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                if (request != null) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view?.loadUrl(request.url.toString())
                }
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                if (progressBarWebView != null && progressBarWebView.isShown)
                    progressBarWebView.visibility = View.GONE
            }

        }

        stringUrl = arguments?.getString("STRING_URL")

        if (stringUrl.equals(Config.URL_SITE_CABINET)) {
            val profile: TSignIn? = modelRoot.getUser()
            getThroughAuthToken(profile?.loginIIN.toString())
        } else {
            bottomSheetWebView.loadUrl(Config.URL_SITE_SIMPLE)
        }
    }

    override fun onDestroyView() {
        bottomSheetWebView.stopLoading()
        super.onDestroyView()
    }

    private fun getThroughAuthToken(iin: String) {
        modelRoot.getThroughAuthToken(iin)
                .withDefaultSchedulers()
                .subscribe({ tokenForUrl ->
                    var stringUrl: String? = Config.URL_SITE_CABINET
                    stringUrl += "default/through-login?iin=$iin&token=$tokenForUrl"
                    bottomSheetWebView.loadUrl(stringUrl)
                }, {
                    Toast.makeText(activity, "Ошибка сети", Toast.LENGTH_LONG).show()
                })
    }

}