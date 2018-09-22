package gomo.hdhuu.com.gomo.business.sample

import durdinapps.rxfirebase2.RxFirebaseDatabase

import gomo.hdhuu.com.gomo.business.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.models.Rating
import io.reactivex.Completable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class RatingUsecaseWithFirebase @Inject constructor() : BaseFirebase(), RatingUsecase {

    private fun sessionRating() = mRootDB.child("userFeedbacks")

    override fun saveRating(ratingId: Int, rating: Rating): Completable {
        return RxFirebaseDatabase.setValue(sessionRating(), rating)
    }

}