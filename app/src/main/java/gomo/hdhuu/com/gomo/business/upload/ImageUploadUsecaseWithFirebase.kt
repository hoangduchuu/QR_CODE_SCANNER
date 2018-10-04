package gomo.hdhuu.com.gomo.business.upload

import android.net.Uri
import android.util.Log
import com.google.firebase.storage.UploadTask
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
    var refString = ""
    override fun buildUseCaseObservable(params: UploadParams): Observable<String> {
        refString = params.reference
        return Observable.create { emmiter ->
            if (params.inputType == UPLOAD_FILE) {
                RxFirebaseStorage.putFile(uploadref(), Uri.fromFile(params.file))
                        .subscribe { t, e ->
                            if (t.task.isSuccessful) {
                                t.metadata?.reference?.downloadUrl?.addOnSuccessListener { uri ->
                                    emmiter.onNext(uri.toString())
                                }
                            } else {
                                emmiter.onError(e)
                            }
                        }
            }
            if (params.inputType.equals(other = UPLOAD_BYTES)) {
                RxFirebaseStorage.putBytes(uploadref(), params.byteArray)
                        .subscribe { t, e ->
                            if (t.task.isSuccessful) {
                                t.metadata?.reference?.downloadUrl?.addOnSuccessListener { uri ->
                                    emmiter.onNext(uri.toString())
                                }
                            } else {
                                emmiter.onError(e)
                            }
                        }


            }

        }
    }

    val time = System.currentTimeMillis()
    private fun uploadref() = mStorage.getReference("huu/ $refString + ${time} .jpg")
}