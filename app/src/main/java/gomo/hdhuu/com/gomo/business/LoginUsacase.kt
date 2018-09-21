package gomo.hdhuu.com.gomo.business

import javax.inject.Named

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface LoginUsacase {
    fun login(user: String, password: String)
}