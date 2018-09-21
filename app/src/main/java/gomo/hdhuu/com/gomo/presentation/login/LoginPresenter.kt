package gomo.hdhuu.com.gomo.presentation.login

import gomo.hdhuu.com.gomo.business.LoginUsacase
import gomo.hdhuu.com.gomo.utils.main_api
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginPresenter @Inject constructor() : LoginContract.Presenter {
    @Inject
    lateinit var loginUsacase: LoginUsacase

    override fun gotoMainPage() {
        loginUsacase.login("x","y")
    }
}