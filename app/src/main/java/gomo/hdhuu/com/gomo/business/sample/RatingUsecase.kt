package gomo.hdhuu.com.gomo.business.sample

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface RatingUsecase<in INPUT_PARAMS, out RESONSE_DATA> {
    fun buildUseCaseObservable(params: INPUT_PARAMS): Observable<out RESONSE_DATA>
}