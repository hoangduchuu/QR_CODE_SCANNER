package gomo.hdhuu.com.gomo.presentation.login.register

import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.di.FragmentScope

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
interface RegisterContract {
    interface View {
        fun onRegisterSuccess()
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
    }
}