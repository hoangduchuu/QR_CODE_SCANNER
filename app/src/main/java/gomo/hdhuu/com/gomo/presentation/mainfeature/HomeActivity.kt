package gomo.hdhuu.com.gomo.presentation.mainfeature

import android.os.Bundle
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.presentation.base.BaseActivity

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class HomeActivity : BaseActivity() {
    override fun initializeView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_home_app)
    }

    override fun injectDependencies() {
    }
}