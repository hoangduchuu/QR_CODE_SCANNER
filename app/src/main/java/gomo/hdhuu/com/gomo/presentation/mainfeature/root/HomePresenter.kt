package gomo.hdhuu.com.gomo.presentation.mainfeature.root

import com.google.firebase.auth.FirebaseAuth
import durdinapps.rxfirebase2.RxFirebaseAuth
import durdinapps.rxfirebase2.RxFirebaseUser
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class HomePresenter
@Inject
constructor() : HomeContract.Presenter {
    /**
     * @View is the view of activity
     */
    @Inject
    lateinit var view: HomeContract.View

    // create signout usecae late
    //todo
    override fun logout() {
        FirebaseAuth.getInstance().signOut()
        view.openLoginScreen()
    }


}