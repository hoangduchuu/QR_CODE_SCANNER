package gomo.hdhuu.com.gomo.presentation.login.register

import com.google.firebase.auth.AuthResult
import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.register.RegisterUsecase
import gomo.hdhuu.com.gomo.business.accouting.register.RegisterUsecaseWithFirebase
import gomo.hdhuu.com.gomo.di.FragmentScope
import gomo.hdhuu.com.gomo.presentation.base.BaseView
import gomo.hdhuu.com.gomo.utils.USE_API_FROM_FIREBASE
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
interface RegisterContract {
    interface View : BaseView {
        fun onRegisterSuccess()
        fun onRegisterFailed(msg: String)
    }

    interface Persenter {
        fun register(user: String, password: String)
    }


    @FragmentScope
    @Subcomponent(modules = [Module::class])
    interface Component {
        fun inject(fragment: RegisterFragment)


    }

    @dagger.Module
    class Module(val view: View) {
        @FragmentScope
        @Provides
        fun provideView() = view

        @FragmentScope
        @Provides
        fun providePresenter(it: RegisterPresenter): RegisterContract.Persenter = it

        @FragmentScope
        @Provides
        @Named(USE_API_FROM_FIREBASE)
        fun provideUsecase(usecase: RegisterUsecaseWithFirebase): RegisterUsecase<AccountParams, AuthResult> = usecase
    }
}