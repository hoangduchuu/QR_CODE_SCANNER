package gomo.hdhuu.com.gomo.presentation.login

import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.business.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.login.LoginUsecaseWithFirebase
import gomo.hdhuu.com.gomo.business.login.LoginUsecaseWithHttp
import gomo.hdhuu.com.gomo.di.ActivityScope
import gomo.hdhuu.com.gomo.presentation.base.BasePresenter
import gomo.hdhuu.com.gomo.presentation.base.BaseView
import gomo.hdhuu.com.gomo.utils.USE_API_FROM_FIREBASE
import gomo.hdhuu.com.gomo.utils.USE_API_FROM_HTTP
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface LoginContract {
    interface View : BaseView {
        fun doLogin(userName: String, password: String)
    }

    interface Presenter : BasePresenter {
        fun gotoMainPage()
    }


    @ActivityScope
    @Subcomponent(modules = [Module::class])
    interface Component {
        fun inject(activity: LoginActivity)
    }

    @dagger.Module
    class Module(val view: View) {
        @ActivityScope
        @Provides
        fun provideView() = view

        @ActivityScope
        @Provides
        fun providePresenter(presenter: LoginPresenter): LoginContract.Presenter = presenter

        @ActivityScope
        @Provides
        @Named(USE_API_FROM_FIREBASE)
        fun provideUsecaseWithFirebase(usecase: LoginUsecaseWithFirebase): LoginUsacase = usecase

        @ActivityScope
        @Provides
        @Named(USE_API_FROM_HTTP)
        fun provideUsecaseWithHttp(usecase: LoginUsecaseWithHttp): LoginUsacase = usecase

    }


}