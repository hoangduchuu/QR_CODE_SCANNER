package gomo.hdhuu.com.gomo.business.accouting.checkUserlogin

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import durdinapps.rxfirebase2.RxFirebaseAuth
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.base.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.models.Rating
import io.reactivex.*
import javax.inject.Inject


/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class CheckLoginUsecaseWithFirebase @Inject constructor() : BaseFirebase(), CheckLoginUsacase {
    override fun getAuthResult(): FirebaseUser? {
        return mAuth.currentUser
    }

    override fun buildUseCaseObservable(): Boolean {
        return mAuth.currentUser != null
    }


}