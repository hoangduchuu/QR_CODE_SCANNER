package gomo.hdhuu.com.gomo.business.accouting.checkUserlogin

import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface CheckLoginUsacase {
    fun buildUseCaseObservable(): Boolean
}

