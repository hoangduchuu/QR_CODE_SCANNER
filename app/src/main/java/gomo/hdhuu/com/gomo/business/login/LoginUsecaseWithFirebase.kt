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

    @SuppressLint("LongLogTag")
    override fun login(user: String, password: String) {
//        mAuth.signInWithEmailAndPassword(user, password)
//                .addOnSuccessListener { Log.e(TAGz, "success") }
//                .addOnFailureListener { Log.e(TAGz, "logi falied") }
        rating(1)

//        RxFirebaseDatabase.setValue(mRootDB.child("abc"),"huuhoa")
//        mRootDB.child("x").setValue(2)
//        mRootDB.child("y").setValue(false)
        saveRating(111, Rating(
                user, 99, 22
        ))
    }

    fun saveRating(sessionId: Int, rating: Rating) {
        sessionRating().child(sessionId.toString()).setValue(rating)

    }

    private val database: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.apply { keepSynced(true) }
    }

    private fun sessionRating() = mRootDB.child("userFeedbacks")
    fun rating(sessionId: Int) {

    }


}