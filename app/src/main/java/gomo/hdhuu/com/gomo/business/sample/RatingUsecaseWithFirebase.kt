package gomo.hdhuu.com.gomo.business.sample

import durdinapps.rxfirebase2.RxFirebaseDatabase

import gomo.hdhuu.com.gomo.business.base.firebase.BaseFirebase
import io.reactivex.Observable
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