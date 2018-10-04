package gomo.hdhuu.com.gomo.business.upload

import android.net.Uri
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.UploadTask
import durdinapps.rxfirebase2.RxFirebaseAuth
import durdinapps.rxfirebase2.RxFirebaseStorage
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.base.firebase.BaseFirebase
import io.reactivex.Observable
import java.io.File
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class ImageUploadUsecaseWithHttp @Inject
constructor() : BaseFirebase(), ImageUploadUsecase {
    override fun buildUseCaseObservable(params: UploadParams): Observable<String> {
        return Observable.just("x")
    }

}