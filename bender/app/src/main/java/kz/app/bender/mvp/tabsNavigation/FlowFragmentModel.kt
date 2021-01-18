package kz.app.bender.mvp.tabsNavigation

import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.AbstractModel
import kz.app.bender.support.stat.Zprefs

class FlowFragmentModel : AbstractModel(), FlowFragmentContract.Model {

    override fun getUserData(): TSignIn? {
        return Zprefs.getUser(sharedPreferences)
    }

}