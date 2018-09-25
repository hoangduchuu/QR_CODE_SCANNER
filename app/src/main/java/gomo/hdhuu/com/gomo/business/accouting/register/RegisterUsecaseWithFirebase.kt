package gomo.hdhuu.com.gomo.business.accouting.register

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import durdinapps.rxfirebase2.RxFirebaseAuth
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.base.firebase.BaseFirebase
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class RegisterUsecaseWithFirebase @Inject
constructor() : BaseFirebase(), RegisterUsecase<AccountParams, AuthResult> {
    override fun buildUseCaseObservable(params: AccountParams): Observable<AuthResult> {
        return RxFirebaseAuth.createUserWithEmailAndPassword(mAuth, params.email, params.password)
                .toObservable()
    }
}