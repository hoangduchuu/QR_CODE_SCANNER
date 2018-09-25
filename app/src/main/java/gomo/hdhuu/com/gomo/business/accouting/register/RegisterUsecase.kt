package gomo.hdhuu.com.gomo.business.accouting.register

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
interface RegisterUsecase<INPUT_PARAM, RESONSE_DATA> {
    fun buildUseCaseObservable(params: INPUT_PARAM): Observable<RESONSE_DATA>

}