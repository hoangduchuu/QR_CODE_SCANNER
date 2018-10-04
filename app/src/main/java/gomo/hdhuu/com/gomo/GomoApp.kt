package gomo.hdhuu.com.gomo

import android.app.Application
import android.content.Context
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import gomo.hdhuu.com.gomo.di.ApplicationDI
import gomo.hdhuu.com.gomo.di.DaggerApplicationDI_Component
import gomo.hdhuu.com.gomo.di.UserDI

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class GomoApp : Application() {
    lateinit var appComponent: ApplicationDI.Component
    lateinit var userComponent: UserDI.Component


    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerApplicationDI_Component.builder()
                .module(ApplicationDI.Module(this))
                .build()
    }

    /**
     * build any what Module inside UserComponent scope need to use like:
     * - UserProfile (logged)
     *
     * We use this function when the user logged success or user state is logged before
     * to PROVIDE ONLY-AND-ONLY-ONE UserProfile instance in the WHOLE application
     */
    fun buildUserScope(user: UserProfile) {
        userComponent = appComponent.plus(UserDI.Module(user))
    }


    companion object {
        @Volatile
        private lateinit var instance: GomoApp

        /**
         * @return this GomoApp instance
         */

        fun getInstance(): GomoApp {
            return instance
        }

        /**
         * @return the userComponent
         */
        fun getUserComponent(): UserDI.Component {
            return getInstance().userComponent
        }
    }


}