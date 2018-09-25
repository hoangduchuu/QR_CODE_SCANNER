package gomo.hdhuu.com.gomo.business.firebase

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
interface BaseFirebase<INPUT_PARAMS, RESONSE_DATA> {
    fun buildUsecase(params: INPUT_PARAMS): Observable<RESONSE_DATA>
}