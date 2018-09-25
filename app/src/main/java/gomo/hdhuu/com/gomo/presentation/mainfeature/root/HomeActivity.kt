package gomo.hdhuu.com.gomo.presentation.mainfeature.root

import android.os.Bundle
import com.hnam.mvvm.replaceFragmentInActivity
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.presentation.base.BaseActivity
import gomo.hdhuu.com.gomo.presentation.mainfeature.OverView.OverViewFragment

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class HomeActivity : BaseActivity(), HomeContract.View {
    /**
     * the Home component
     */
    var component: HomeContract.Component? = null


    /**
     * setup view and bindind
     */
    override fun initializeView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_app)
        replaceFragmentInActivity(OverViewFragment(), getFragmentContaier())
    }

    /**
     * dependencies injection
     */
    override fun injectDependencies() {
        component = (application as GomoApp).component
                .plus(HomeContract.Module(this))
        component?.inject(this)
    }

    /**
     * the frame layout to show fragment in this activity
     */
    private fun getFragmentContaier(): Int {
        return R.id.fragment_container
    }
}