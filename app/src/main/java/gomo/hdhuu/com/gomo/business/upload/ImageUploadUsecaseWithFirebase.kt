package gomo.hdhuu.com.gomo.business.upload

import android.net.Uri
import durdinapps.rxfirebase2.RxFirebaseStorage
import gomo.hdhuu.com.gomo.business.base.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.utils.UPLOAD_BYTES
import gomo.hdhuu.com.gomo.utils.UPLOAD_FILE
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class ImageUploadUsecaseWithFirebase @Inject
constructor() : BaseFirebase(), ImageUploadUsecase {
    override fun buildUseCaseObservable(params: UploadParams): Observable<String> {
        return Observable.create { emmiter ->
            if (params.inputType.equals(UPLOAD_FILE)) RxFirebaseStorage.putFile(params.reference, Uri.fromFile(params.file))
                    .subscribe { t, e ->
                        if (t.task.isSuccessful) {
                            emmiter.onNext(t.uploadSessionUri.toString())
                        } else {
                            emmiter.onError(e)
                        }
                    }
            if (params.inputType.equals(UPLOAD_BYTES)) {
                RxFirebaseStorage.putBytes(params.reference, params.byteArray)
                        .subscribe { t, e ->
                            if (t.task.isSuccessful) {
                                emmiter.onNext(t.uploadSessionUri.toString())
                            } else {
                                emmiter.onError(e)
                            }
                        }
            }

        }
    }
}