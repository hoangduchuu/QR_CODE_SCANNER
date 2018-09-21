package gomo.hdhuu.com.gomo.business.login

import android.annotation.SuppressLint
import android.util.Log
import gomo.hdhuu.com.gomo.business.firebase.BaseFirebase
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithFirebase @Inject constructor() : BaseFirebase(), LoginUsacase {
    val TAGz = "LoginUsecaseWithFirebase"

    @SuppressLint("LongLogTag")
    override fun login(user: String, password: String) {
        mAuth.signInWithEmailAndPassword(user, password)
                .addOnSuccessListener { Log.e(TAGz, "success") }
                .addOnFailureListener { Log.e(TAGz, "logi falied") }
    }
}