package gomo.hdhuu.com.gomo.business.menu

import durdinapps.rxfirebase2.RxFirebaseDatabase
import gomo.hdhuu.com.gomo.business.base.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.utils.cons.KEY_MENUS
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 10/5/18 .
 */
class PostMenuWithFirebase @Inject constructor() : BaseFirebase(), PostMenu {
    override fun buildUseCaseObservable(params: MenuParams): Observable<Unit> {
        return RxFirebaseDatabase.setValue(getTargetPath(), params).toObservable()
    }

    private fun getTargetPath() = mRootDB.child("$KEY_MENUS / ${getLoggedUUid()}").push()
}