package gomo.hdhuu.com.gomo.di

import android.content.Context
import dagger.Provides
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.presentation.login.LoginContract
import javax.inject.Singleton

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface ApplicationDI {
    @Singleton
    @dagger.Component(modules = arrayOf(Module::class))
    interface Component {
        fun plus(module: LoginContract.Module): LoginContract.Component

    }

    @dagger.Module
    class Module(private val application: GomoApp) {
        @Provides
        @Singleton
        fun provideApplicationContext(): Context = application
    }
}