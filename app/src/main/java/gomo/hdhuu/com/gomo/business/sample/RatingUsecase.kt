package gomo.hdhuu.com.gomo.business.sample

import gomo.hdhuu.com.gomo.models.Rating
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface RatingUsecase {
    fun saveRating(ratingId: Int, rating: Rating): Completable
}