package gomo.hdhuu.com.gomo.presentation.mainfeature.root

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.MenuItem
import butterknife.OnClick
import com.hnam.mvvm.replaceFragmentInActivity
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.presentation.base.BaseActivity
import gomo.hdhuu.com.gomo.presentation.login.LoginActivity
import gomo.hdhuu.com.gomo.presentation.mainfeature.OverView.OverViewFragment
import kotlinx.android.synthetic.main.activity_home_app.*
import javax.inject.Inject
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class HomeActivity : BaseActivity(), HomeContract.View, NavigationView.OnNavigationItemSelectedListener {
    /**
     * the Home component
     */
    var homeComponent: HomeContract.Component? = null

    /**
     * @presenter is presenter of activity
     */

    @Inject
    lateinit var presenter: HomeContract.Presenter

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
        homeComponent = GomoApp
                .getUserComponent()
                .plus(HomeContract.Module(this))

        homeComponent?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nav_view.setNavigationItemSelectedListener(this)
    }

    /**
     * the frame layout to show fragment in this activity
     */
    private fun getFragmentContaier(): Int {
        return R.id.fragment_container
    }

    override fun openLoginScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        this.finish()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_logout -> {
                presenter.logout()
            }
            else -> {
                //nothing to do
            }
        }
        return true
    }
}