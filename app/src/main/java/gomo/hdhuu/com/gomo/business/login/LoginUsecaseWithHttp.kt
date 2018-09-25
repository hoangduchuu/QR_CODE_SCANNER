package gomo.hdhuu.com.gomo.business.login

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithHttp @Inject constructor() : LoginUsacase<LoginParams, String> {
    override fun buildUseecase(params: LoginParams): Observable<String> {
        return Observable.just("x")
    }


}
