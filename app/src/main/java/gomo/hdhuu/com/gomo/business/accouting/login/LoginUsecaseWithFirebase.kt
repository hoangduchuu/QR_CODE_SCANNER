package gomo.hdhuu.com.gomo.business.accouting.login

import com.google.firebase.auth.AuthResult
import com.google.firebase.database.*
import durdinapps.rxfirebase2.RxFirebaseAuth
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.base.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.models.Rating
import io.reactivex.*
import javax.inject.Inject


/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithFirebase @Inject constructor() : BaseFirebase(), LoginUsacase<AccountParams, AuthResult> {
    override fun buildUseCaseObservable(params: AccountParams): Observable<AuthResult> {
        return RxFirebaseAuth.signInWithEmailAndPassword(mAuth, params.email, params.password)
                .toObservable()
    }


    val TAGz = "LoginUsecaseWithFirebase"
    var num = 1


    fun saveRating(sessionId: Int, rating: Rating) {
        sessionRating().child(sessionId.toString()).setValue(rating)

    }

    private val database: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.apply { keepSynced(true) }
    }

    private fun sessionRating() = mRootDB.child("userFeedbacks")


}