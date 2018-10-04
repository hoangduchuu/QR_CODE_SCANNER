package gomo.hdhuu.com.gomo.di

import dagger.Provides
import dagger.Subcomponent
import gomo.hdhuu.com.gomo.UserProfile
import gomo.hdhuu.com.gomo.di.scope.UserScope
import gomo.hdhuu.com.gomo.presentation.mainfeature.root.HomeContract

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
    class Module(val user: UserProfile) {

        @Provides
        @UserScope
        fun provideUserProfile(): UserProfile = user
    }
}