package gomo.hdhuu.com.gomo.business.login

import io.reactivex.Observable
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface LoginUsacase<RESONSE_DATA> {
    fun login(user: String, password: String) : Observable<RESONSE_DATA>
}