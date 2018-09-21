package gomo.hdhuu.com.gomo.presentation.login

import gomo.hdhuu.com.gomo.business.LoginUsacase
import gomo.hdhuu.com.gomo.utils.MAIN_API
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginPresenter @Inject constructor(@param:Named(MAIN_API) private val login: LoginUsacase) : LoginContract.Presenter {

    override fun gotoMainPage() {
        login.login("x", "y")
    }
}