package gomo.hdhuu.com.gomo.presentation.login

import android.util.Log
import com.google.firebase.auth.AuthResult
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
class LoginPresenter @Inject constructor(@param:Named(MAIN_API) private val login: LoginUsacase<AuthResult>, private val rating: RatingUsecase) : LoginContract.Presenter {
    val r = Random();
    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModel: LoginViewModel


    override fun doLogin(userName: String, password: String) {
        viewModel.status.set("loading")
        login.login(userName, password)
                .subscribe({ it -> viewModel.status.set("OKKKK") },
                        { throwables ->  viewModel.status.set(throwables.localizedMessage) })

    }


}