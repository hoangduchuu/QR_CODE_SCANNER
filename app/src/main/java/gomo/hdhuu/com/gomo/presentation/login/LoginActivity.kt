package gomo.hdhuu.com.gomo.presentation.login

import android.os.Bundle
import android.util.Log
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.presentation.base.BaseActivity
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginActivity : BaseActivity(), LoginContract.View {
    @Inject
    lateinit var mPresenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LoginActivity-z", mPresenter.toString())
    }

    override fun showDialog(msg: String) {
    }

    override fun showDialog(title: String, msg: String) {
    }

    override fun showDialog(title: String, msg: String, cancelable: Boolean) {
    }

    override fun doLogin(userName: String, password: String) {
    }

    override fun initializeView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
    }

    override fun injectDependencies() {
        (application as GomoApp).component
                .plus(LoginContract.Module(this))
                .inject(this)
        mPresenter.gotoMainPage()
    }

}