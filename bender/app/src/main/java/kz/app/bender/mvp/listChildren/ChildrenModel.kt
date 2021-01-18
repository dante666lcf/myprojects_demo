package kz.app.bender.mvp.listChildren

import kz.app.bender.models.TChildrenItem
import kz.app.bender.models.TSignIn
import kz.app.bender.mvp.AbstractModel
import kz.app.bender.support.stat.Zprefs
import rx.Single

class ChildrenModel : AbstractModel(), ChildrenContract.Model {

    override fun getMyChildren(): Single<ArrayList<TChildrenItem>> {
        return createDefaultRequestSingle(restAPI.getMyChildren(getIIN()))
    }

    private fun getIIN(): String {
        val signIn: TSignIn? = Zprefs.getUser(sharedPreferences)
        return signIn?.loginIIN.toString()
    }

}