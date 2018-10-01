package gomo.hdhuu.com.gomo.presentation.mainfeature.OverView

import gomo.hdhuu.com.gomo.UserProfile
import gomo.hdhuu.com.gomo.presentation.base.BasePresenter
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class OverViewPresenter
@Inject constructor() : BasePresenter, OverViewContract.Presenter {
    override fun getName(): String {
        return userProfile.name
    }

    @Inject
    lateinit var userProfile : UserProfile


}