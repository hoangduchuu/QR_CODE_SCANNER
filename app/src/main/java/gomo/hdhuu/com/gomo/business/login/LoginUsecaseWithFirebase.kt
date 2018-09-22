package gomo.hdhuu.com.gomo.business.login

import android.annotation.SuppressLint
import android.databinding.adapters.RatingBarBindingAdapter.setRating
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import gomo.hdhuu.com.gomo.business.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.models.Rating
import io.reactivex.*
import org.reactivestreams.Subscriber
import javax.inject.Inject


/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithFirebase @Inject constructor() : BaseFirebase(), LoginUsacase {
    val TAGz = "LoginUsecaseWithFirebase"
    var num = 1

    @SuppressLint("LongLogTag")
    override fun login(user: String, password: String) {
        num++
        saveRating(num + 1, Rating(
                user + password, num + 1, num + 1
        ))
    }

    fun saveRating(sessionId: Int, rating: Rating) {
        sessionRating().child(sessionId.toString()).setValue(rating)

    }

    private val database: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.apply { keepSynced(true) }
    }

    private fun sessionRating() = mRootDB.child("userFeedbacks")



}