package gomo.hdhuu.com.gomo.presentation.login

import com.google.firebase.auth.AuthResult
import gomo.hdhuu.com.gomo.business.login.LoginParams
import gomo.hdhuu.com.gomo.business.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.sample.RatingParams
import gomo.hdhuu.com.gomo.business.sample.RatingUsecase
import gomo.hdhuu.com.gomo.utils.MAIN_API
import java.util.*
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginPresenter
@Inject
constructor(@param:Named(MAIN_API) private val login: LoginUsacase<LoginParams, AuthResult>,
            private val rating: RatingUsecase<RatingParams, String>) : LoginContract.Presenter {
    val r = Random();
    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModel: LoginViewModel
    @Inject
    lateinit var view: LoginContract.View

    override fun doLogin(userName: String, password: String) {
        view.showLoading()
        viewModel.status.set("loading")
        login.buildUseCaseObservable(LoginParams(userName, password))
                .doFinally{view.hideLoading()}
                .subscribe(
                        { it -> viewModel.status.set("OKKKK") }
                        , { throwables -> viewModel.status.set(throwables.localizedMessage) }
                        , { view.hideLoading() })


    }


}