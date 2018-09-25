package gomo.hdhuu.com.gomo.business.login

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface LoginUsacase<INPUT_PARAM,RESONSE_DATA> {
    fun buildUseCaseObservable(params: INPUT_PARAM): Observable<RESONSE_DATA>
}

