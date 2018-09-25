package gomo.hdhuu.com.gomo.presentation.login

import com.google.firebase.auth.AuthResult
import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.business.login.LoginParams
import gomo.hdhuu.com.gomo.business.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.login.LoginUsecaseWithFirebase
import gomo.hdhuu.com.gomo.business.login.LoginUsecaseWithHttp
import gomo.hdhuu.com.gomo.business.sample.RatingParams
import gomo.hdhuu.com.gomo.business.sample.RatingUsecase
import gomo.hdhuu.com.gomo.business.sample.RatingUsecaseWithFirebase
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
        fun gotoMainPage()

    }

    interface Presenter : BasePresenter {
        fun doLogin(userName: String, password: String)
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
        fun provideUsecaseWithFirebase(usecase: LoginUsecaseWithFirebase): LoginUsacase<LoginParams, AuthResult> = usecase

        @ActivityScope
        @Provides
        @Named(USE_API_FROM_HTTP)
        fun provideUsecaseWithHttp(usecase: LoginUsecaseWithHttp): LoginUsacase<LoginParams, String> = usecase

        @ActivityScope
        @Provides
        fun provideRating(usecas: RatingUsecaseWithFirebase): RatingUsecase<RatingParams, String> = usecas

        @ActivityScope
        @Provides
        fun provideViewMode() = LoginViewModel()

    }


}