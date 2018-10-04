package gomo.hdhuu.com.gomo.business.upload

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface ImageUploadUsecase {
    fun buildUseCaseObservable(params: UploadParams): Observable<String>
}

