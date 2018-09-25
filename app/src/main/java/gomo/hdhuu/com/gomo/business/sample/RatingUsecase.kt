package gomo.hdhuu.com.gomo.business.sample

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface RatingUsecase<INPUT_PARAM,RESONSE_DATA> {
    fun buildUseCaseObservable(params: INPUT_PARAM): Observable<RESONSE_DATA>
}