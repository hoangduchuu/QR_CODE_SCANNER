package gomo.hdhuu.com.gomo.business.menu

import io.reactivex.Observable
import java.util.*

/**
 * Created by hoangduchuuvn@gmail.com on 10/5/18 .
 */
interface PostMenu {
    fun buildUseCaseObservable(params: MenuParams): Observable<Unit>
}