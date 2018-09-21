package gomo.hdhuu.com.gomo.business

import android.util.Log
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginUsecaseWithFirebase @Inject constructor() : LoginUsacase {
    override fun login(user: String, password: String) {
        Log.e("loginDo", "called")
    }
}