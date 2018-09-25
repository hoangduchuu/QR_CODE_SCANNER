package gomo.hdhuu.com.gomo.business.accouting.login

import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithHttp @Inject constructor() : LoginUsacase<AccountParams, String> {
    override fun buildUseCaseObservable(params: AccountParams): Observable<String> {
        return Observable.just("x")
    }

}
