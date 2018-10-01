package gomo.hdhuu.com.gomo.di

import android.content.Context
import dagger.Provides
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.presentation.login.LoginContract
import gomo.hdhuu.com.gomo.presentation.mainfeature.root.HomeContract
import javax.inject.Singleton

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface ApplicationDI {
    @Singleton
    @dagger.Component(modules = arrayOf(ApplicationDI.Module::class))
    interface Component {
        fun plus(module: LoginContract.Module): LoginContract.Component
        fun plus(module: UserDI.Module): UserDI.Component

    }

    @dagger.Module
    class Module(private val application: GomoApp) {
        @Provides
        @Singleton
        fun provideApplicationContext(): Context = application
    }
}