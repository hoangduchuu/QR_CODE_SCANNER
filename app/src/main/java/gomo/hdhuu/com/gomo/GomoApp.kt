package gomo.hdhuu.com.gomo

import android.app.Application
import gomo.hdhuu.com.gomo.di.ApplicationDI
import gomo.hdhuu.com.gomo.di.DaggerApplicationDI_Component

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class GomoApp : Application() {
    lateinit var component: ApplicationDI.Component

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationDI_Component.builder()
                .module(ApplicationDI.Module(this))
                .build()
    }

}