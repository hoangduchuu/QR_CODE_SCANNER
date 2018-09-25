package gomo.hdhuu.com.gomo.presentation.login.register

import android.annotation.SuppressLint
import com.google.firebase.auth.AuthResult
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.register.RegisterUsecase
import gomo.hdhuu.com.gomo.utils.MAIN_API
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
@SuppressLint("CheckResult")
class RegisterPresenter
@Inject
constructor(@param:Named(MAIN_API) private val useCase: RegisterUsecase<AccountParams, AuthResult>) : RegisterContract.Persenter {
    @Inject
    lateinit var view: RegisterContract.View

    override fun register(user: String, password: String) {
        view.showLoading()
        useCase.buildUseCaseObservable(AccountParams(user, password))
                .subscribe({ handleSuccess() },
                        { throwables -> handleError(throwables) })
    }

    fun handleSuccess() {
        view.onRegisterSuccess()
        view.hideLoading()
    }

    fun handleError(throws: Throwable) {
        view.onRegisterFailed(throws.localizedMessage)

    }

}