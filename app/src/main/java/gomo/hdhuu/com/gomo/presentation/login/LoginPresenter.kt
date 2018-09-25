package gomo.hdhuu.com.gomo.presentation.login

import android.annotation.SuppressLint
import com.google.firebase.auth.AuthResult
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsacase
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
constructor(@param:Named(MAIN_API) private val login: LoginUsacase<AccountParams, AuthResult>,
            private val rating: RatingUsecase<RatingParams, String>) : LoginContract.Presenter {
    override fun gotoMainPage() {
        view.gotoMainPage()
    }

    val r = Random();
    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModel: LoginViewModel
    @Inject
    lateinit var view: LoginContract.View

    @SuppressLint("CheckResult")
    override fun doLogin(userName: String, password: String) {
        view.showLoading()
        viewModel.status.set("loading")
        login.buildUseCaseObservable(AccountParams(userName, password))
                .doFinally {
                }
                .subscribe(
                        { it ->
                            viewModel.status.set("OKKKK")
                            view.hideLoading()
                            view.gotoMainPage()
                        }
                        , { throwables ->
                    viewModel.status.set(throwables.localizedMessage)
                    view.onLoginErrors(throwables.localizedMessage)

                }
                )


    }


}