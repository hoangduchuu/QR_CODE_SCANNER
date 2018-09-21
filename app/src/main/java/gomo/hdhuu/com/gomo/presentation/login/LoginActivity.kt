package gomo.hdhuu.com.gomo.presentation.login

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import butterknife.OnClick
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginActivity : BaseActivity(), LoginContract.View {
    val TAG = this.javaClass.simpleName


    override fun gotoMainPage() {
        Toast.makeText(applicationContext, "xxx", Toast.LENGTH_LONG).show()
    }

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


    override fun initializeView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_login)
    }

    @OnClick(R.id.btnLogin)
    fun doLogin() {
        // todo remove log
        Log.e(TAG, "login clicked")
        mPresenter.doLogin(tvUser.text.trim().toString(), tvPassword.text.trim().toString())
    }

    override fun injectDependencies() {
        (application as GomoApp).component
                .plus(LoginContract.Module(this))
                .inject(this)

    }

}