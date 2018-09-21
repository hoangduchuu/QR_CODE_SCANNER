package gomo.hdhuu.com.gomo.presentation.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView(savedInstanceState)
        injectDependencies()
        ButterKnife.bind(this)
    }

    protected abstract fun initializeView(savedInstanceState: Bundle?)
    protected abstract fun injectDependencies()
}