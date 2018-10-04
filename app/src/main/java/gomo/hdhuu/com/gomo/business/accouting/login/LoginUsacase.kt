package gomo.hdhuu.com.gomo.business.accouting.login

import gomo.hdhuu.com.gomo.UserProfile
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import io.reactivex.Observable

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface LoginUsacase {
    fun buildUseCaseObservable(params: AccountParams): Observable<UserProfile>
}

