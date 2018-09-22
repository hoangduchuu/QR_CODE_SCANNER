package gomo.hdhuu.com.gomo.presentation.login

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
    override fun doLogin(userName: String, password: String) {
        rating.saveRating(12 + 1, Rating(userName + password, 99 + 2, 22))
                .subscribe({
                    // Update successful

                }) {
                    // Somthing went wrong
                }

    }


}