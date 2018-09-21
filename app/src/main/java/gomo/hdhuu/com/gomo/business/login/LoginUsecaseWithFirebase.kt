package gomo.hdhuu.com.gomo.business.login

import android.util.Log
import gomo.hdhuu.com.gomo.business.firebase.BaseFirebase
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithFirebase @Inject constructor() : BaseFirebase(), LoginUsacase {
    override fun login(user: String, password: String) {
        
    }
}