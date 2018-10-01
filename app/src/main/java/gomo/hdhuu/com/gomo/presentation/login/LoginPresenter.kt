package gomo.hdhuu.com.gomo.presentation.login

import android.accounts.Account
import android.annotation.SuppressLint
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.DatabaseReference
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.R.string.login
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.checkUserlogin.CheckLoginUsacase
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsecaseWithFirebase
import gomo.hdhuu.com.gomo.business.sample.RatingParams
import gomo.hdhuu.com.gomo.business.sample.RatingUsecase
import gomo.hdhuu.com.gomo.utils.MAIN_API
import java.util.*
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
open class LoginPresenter
@Inject
constructor() : LoginContract.Presenter {
    /**
     * @login is implementation of @LoginUsecae
     */
    @Inject
    @field:Named(MAIN_API)
    lateinit var login: LoginUsacase<AccountParams, AuthResult>

    /**
     * @checkLogin is implementation of @CheckLoginUsacase
     */
    @Inject
    lateinit var checkLogin: CheckLoginUsacase

    /**
     * @view is view of activity
     */
    @Inject
    lateinit var view: LoginContract.View

    override fun checkUserLogged() {
        if (checkLogin.buildUseCaseObservable()) {
            GomoApp.getInstance().buildUserScope(checkLogin.getAuthResult()!!)
            gotoMainPage()
        }
    }

    override fun gotoMainPage() {
        view.gotoMainPage()
    }

    val TAG = this.javaClass.simpleName

    @Inject
    lateinit var viewModel: LoginViewModel


    @SuppressLint("CheckResult")
    override fun doLogin(userName: String, password: String) {
        view.showLoading()
        //viewModel.status.set("loading")
        login.buildUseCaseObservable(AccountParams(userName, password))
                .doFinally {
                }
                .subscribe(
                        { it ->
                            //viewModel.status.set("OKKKK")
                            GomoApp.getInstance().buildUserScope(it.user)
                            view.hideLoading()
                            view.gotoMainPage()
                        }
                        , { throwables ->
                    //viewModel.status.set(throwables.localizedMessage)
                    view.onLoginErrors(throwables.localizedMessage)

                }
                )


    }


}