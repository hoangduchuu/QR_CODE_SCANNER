package gomo.hdhuu.com.gomo.business.login

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface LoginUsacase<INPUT_DATA, RESONSE_DATA> {
    fun buildUseecase(params: INPUT_DATA): Observable<RESONSE_DATA>
}

