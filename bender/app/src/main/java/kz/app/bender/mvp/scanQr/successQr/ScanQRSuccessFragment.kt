package kz.app.bender.mvp.scanQr.successQr

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_scan_qr_success.*
import kz.app.bender.R
import kz.app.bender.models.TDate
import kz.app.bender.mvp.IndigoMVPFragment
import kz.app.bender.support.navigation.Screens
import kz.app.bender.support.provider.FragmentProvider

class ScanQRSuccessFragment : IndigoMVPFragment<ScanQRSuccessPresenter>(), ScanQRSuccessView {

    //region Companion
    companion object {
        fun newInstance(dateNoteChild: TDate): ScanQRSuccessFragment {
            val fragment = ScanQRSuccessFragment()
            val args = Bundle()
            args.putSerializable("DATE_NOTE_CHILD", dateNoteChild)
            fragment.arguments = args
            return fragment
        }
    }
    //endregion

    //region DI
    @InjectPresenter
    lateinit var mPresenter: ScanQRSuccessPresenter

    @ProvidePresenter
    internal fun providesScanQRSuccessPresenter(): ScanQRSuccessPresenter {
        return ScanQRSuccessPresenter(router)
    }

    override fun getPresenter(): ScanQRSuccessPresenter {
        return mPresenter
    }
    //endregion

    override fun getFragmentProvider(): FragmentProvider {
        return FragmentProvider()
                .setToolbarTitle(getString(R.string.scan_code))
                .setToolbarArrowColor(R.color.colorPrimary)
                .setLayoutResourceId(R.layout.fragment_scan_qr_success)
    }

    override fun prepareUI() {
        mBtnOkay.setOnClickListener {
            router.backTo(Screens.getChildrenList())
        }

        val dateNoteChild: TDate = arguments?.getSerializable("DATE_NOTE_CHILD") as TDate
        tvSuccessNoteChild.text = getString(R.string.scan_qr_success_text, dateNoteChild.date.toString())

    }
}