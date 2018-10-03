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
    lateinit var component: ApplicationDI.Component



    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationDI_Component.builder()
                .module(ApplicationDI.Module(this))
                .build()
    }

    var userComponent : UserDI.Component? = null
    fun buildUserScope(user: UserProfile) {
        userComponent = component.plus(UserDI.Module(user))
    }

    companion object {
        @Volatile
        private lateinit var instance: GomoApp

        fun getInstance(): GomoApp{
            return instance
        }
    }




}