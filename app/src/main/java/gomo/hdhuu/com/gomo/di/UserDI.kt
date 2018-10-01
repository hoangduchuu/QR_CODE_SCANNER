package gomo.hdhuu.com.gomo.di

import android.content.Context
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.UserProfile
import gomo.hdhuu.com.gomo.presentation.login.LoginContract
import gomo.hdhuu.com.gomo.presentation.mainfeature.root.HomeContract
import javax.inject.Singleton

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface UserDI {
    @UserScope
    @Subcomponent(modules = arrayOf(UserDI.Module::class))
    interface Component {
        fun plus(module: HomeContract.Module): HomeContract.Component
    }

    @dagger.Module
    class Module(val user: FirebaseUser) {

        @Provides
        @UserScope
        fun provideUserProfile(): UserProfile = UserProfile(user.email!!)
    }
}