package gomo.hdhuu.com.gomo.business.login

import android.util.Log
import com.google.firebase.auth.AuthResult
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithHttp @Inject constructor() : LoginUsacase<String> {
    override fun login(user: String, password: String): Observable<String> {
        return Observable.just("x")
    }

}
