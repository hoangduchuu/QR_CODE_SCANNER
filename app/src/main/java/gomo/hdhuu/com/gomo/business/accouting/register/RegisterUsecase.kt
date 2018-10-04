package gomo.hdhuu.com.gomo.business.accouting.register

import com.google.firebase.auth.AuthResult
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
interface RegisterUsecase {
    fun buildUseCaseObservable(params: AccountParams): Observable<AuthResult>

}