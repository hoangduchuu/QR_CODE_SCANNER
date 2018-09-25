package gomo.hdhuu.com.gomo.business.sample

import android.net.Credentials
import com.google.firebase.auth.AuthResult
import durdinapps.rxfirebase2.RxFirebaseDatabase

import gomo.hdhuu.com.gomo.business.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.models.Rating
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class RatingUsecaseWithFirebase @Inject constructor() : BaseFirebase(), RatingUsecase<RatingParams,String> {
    override fun buildUseCaseObservable(params: RatingParams): Observable<String> {
        return RxFirebaseDatabase.setValue(sessionRating(), params.key).toObservable()
    }


    private fun sessionRating() = mRootDB.child("userFeedbacks")


}