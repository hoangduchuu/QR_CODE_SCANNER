package gomo.hdhuu.com.gomo.presentation.login

import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.UserProfile
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.checkUserlogin.CheckLoginUsacase
import gomo.hdhuu.com.gomo.business.accouting.checkUserlogin.CheckLoginUsecaseWithFirebase
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsecaseWithFirebase
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsecaseWithHttp
import gomo.hdhuu.com.gomo.business.sample.RatingParams
import gomo.hdhuu.com.gomo.business.sample.RatingUsecase
import gomo.hdhuu.com.gomo.business.sample.RatingUsecaseWithFirebase
import gomo.hdhuu.com.gomo.business.upload.ImageUploadUsecase
import gomo.hdhuu.com.gomo.business.upload.ImageUploadUsecaseWithFirebase
import gomo.hdhuu.com.gomo.di.scope.ActivityScope
import gomo.hdhuu.com.gomo.presentation.base.BasePresenter
import gomo.hdhuu.com.gomo.presentation.base.BaseView
import gomo.hdhuu.com.gomo.presentation.login.register.RegisterContract
import gomo.hdhuu.com.gomo.utils.USE_API_FROM_FIREBASE
import gomo.hdhuu.com.gomo.utils.USE_API_FROM_HTTP
import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface LoginContract {
    interface View : BaseView {
        fun gotoMainPage()
        fun onLoginErrors(msg: String)

    }

    interface Presenter : BasePresenter {
        fun doLogin(userName: String, password: String)
        fun gotoMainPage()
        fun checkUserLogged()
    }


    @ActivityScope
    @Subcomponent(modules = [Module::class])
    interface Component {
        fun inject(activity: LoginActivity)

        fun plus(module: RegisterContract.Module): RegisterContract.Component

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

        @ActivityScope
        @Provides
        fun provideRating(usecas: RatingUsecaseWithFirebase): RatingUsecase<RatingParams, String> = usecas

        @ActivityScope
        @Provides
        fun provideViewMode() = LoginViewModel()

        @ActivityScope
        @Provides
        fun providecheckUserLoginUsecae(usecas: CheckLoginUsecaseWithFirebase): CheckLoginUsacase = usecas

        @ActivityScope
        @Provides
        fun providetEST(u: ImageUploadUsecaseWithFirebase): ImageUploadUsecase = u

    }


}