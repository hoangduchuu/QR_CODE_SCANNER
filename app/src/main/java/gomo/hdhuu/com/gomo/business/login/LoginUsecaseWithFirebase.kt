package gomo.hdhuu.com.gomo.business.login

import android.annotation.SuppressLint
import android.databinding.adapters.RatingBarBindingAdapter.setRating
import android.util.Log
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import durdinapps.rxfirebase2.RxFirebaseAuth
import gomo.hdhuu.com.gomo.business.firebase.BaseFirebase
import gomo.hdhuu.com.gomo.models.Rating
import io.reactivex.*
import org.reactivestreams.Subscriber
import javax.inject.Inject


/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithFirebase @Inject constructor() : BaseFirebase(), LoginUsacase<AuthResult> {
    val TAGz = "LoginUsecaseWithFirebase"
    var num = 1

    override fun login(user: String, password: String): Observable<AuthResult> {
        return RxFirebaseAuth.signInWithEmailAndPassword(mAuth, user, password)
                .toObservable()

    }

    fun saveRating(sessionId: Int, rating: Rating) {
        sessionRating().child(sessionId.toString()).setValue(rating)

    }

    private val database: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.apply { keepSynced(true) }
    }

    private fun sessionRating() = mRootDB.child("userFeedbacks")



}