package gomo.hdhuu.com.gomo.presentation.login

import android.util.Log
import gomo.hdhuu.com.gomo.business.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.sample.RatingUsecase
import gomo.hdhuu.com.gomo.models.Rating
import gomo.hdhuu.com.gomo.utils.MAIN_API
import java.util.*
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginPresenter @Inject constructor(@param:Named(MAIN_API) private val login: LoginUsacase, private val rating: RatingUsecase) : LoginContract.Presenter {
    val r = Random();
    val TAG = this.javaClass.simpleName
    var plus = 10

    override fun doLogin(userName: String, password: String) {
        plus+=1
        rating.saveRating(1, Rating(userName + password, plus, plus))
                .subscribe({



                }) {
                    // Somthing went wrong
                    Log.i(TAG, "login falied: ");

                }

    }


}