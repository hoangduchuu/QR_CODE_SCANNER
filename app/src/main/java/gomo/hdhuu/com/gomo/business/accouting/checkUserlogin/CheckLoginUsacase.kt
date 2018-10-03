package gomo.hdhuu.com.gomo.business.accouting.checkUserlogin

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import gomo.hdhuu.com.gomo.UserProfile
import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface CheckLoginUsacase {
    fun buildUseCaseObservable(): Boolean
    fun getUserProfileLogged(): UserProfile
}

