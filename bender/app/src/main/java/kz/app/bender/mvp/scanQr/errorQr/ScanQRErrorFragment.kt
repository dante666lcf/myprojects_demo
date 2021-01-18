package kz.app.bender.mvp.scanQr.errorQr

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_scan_qr_error.*
import kz.app.bender.R
import kz.app.bender.models.TChildrenItem
import kz.app.bender.mvp.IndigoMVPFragment
import kz.app.bender.support.navigation.Screens
import kz.app.bender.support.provider.FragmentProvider

class ScanQRErrorFragment : IndigoMVPFragment<ScanQRErrorPresenter>(), ScanQRErrorView {

    //region Companion
    companion object {
        fun newInstance(childItem: TChildrenItem): ScanQRErrorFragment {
            val fragment = ScanQRErrorFragment()
            val args = Bundle()
            args.putSerializable("CHILDREN_ITEM", childItem)
            fragment.arguments = args
            return fragment
        }
    }
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: ScanQRErrorPresenter

    @ProvidePresenter
    internal fun providesScanQRErrorPresenter(): ScanQRErrorPresenter {
        return ScanQRErrorPresenter(router)
    }

    override fun getPresenter(): ScanQRErrorPresenter {
        return mPresenter
    }
    //endregion

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setToolbarTitle(getString(R.string.scan_code))
                .setToolbarArrowColor(R.color.colorPrimary)
                .setLayoutResourceId(R.layout.fragment_scan_qr_error)
    }

    override fun prepareUI() {
        mBtnRepeat.setOnClickListener {
            router.exit()
            router.navigateTo(Screens.getScanQR(arguments?.getSerializable("CHILDREN_ITEM") as TChildrenItem?))
        }

        mBtnCancel.setOnClickListener {
            router.exit()
        }
    }

}