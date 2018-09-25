package gomo.hdhuu.com.gomo.presentation.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.OnClick
import com.hnam.mvvm.replaceFragmentInActivity
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.databinding.ActivityLoginBinding
import gomo.hdhuu.com.gomo.databinding.ActivityMainBinding
import gomo.hdhuu.com.gomo.models.DemoViewModel
import gomo.hdhuu.com.gomo.presentation.base.BaseActivity
import gomo.hdhuu.com.gomo.presentation.home.MainActivity
import gomo.hdhuu.com.gomo.presentation.login.register.RegisterFragment
import gomo.hdhuu.com.gomo.presentation.main.HomeAppActivity
import gomo.hdhuu.com.gomo.presentation.mainfeature.GomoActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginActivity : BaseActivity(), LoginContract.View {
    override fun onLoginErrors(msg: String) {
        showErrorMessage(msg, getString(R.string.login_falied))
    }

    val TAG = this.javaClass.simpleName
    var mBinding: ActivityLoginBinding? = null

    @Inject
    lateinit var mViewModel: LoginViewModel
    var component: LoginContract.Component? = null


    override fun gotoMainPage() {
        Toast.makeText(applicationContext, "xxx", Toast.LENGTH_LONG).show()
        val intent = Intent(this, GomoActivity::class.java)
        startActivity(intent)
        finish()

    }

    @Inject
    lateinit var mPresenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnLogin.setOnClickListener { doLogin() }
        btnRegister.setOnClickListener { openRegister() }

    }

    private fun openRegister() {
        this.replaceFragmentInActivity(RegisterFragment(), R.id.container)
    }


    override fun initializeView(savedInstanceState: Bundle?) {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        ButterKnife.bind(this, mBinding!!.root)

    }

    fun doLogin() {
        mPresenter.doLogin(tvUser.text.trim().toString(), tvPassword.text.trim().toString())
    }

    override fun injectDependencies() {
        component = (application as GomoApp).component
                .plus(LoginContract.Module(this))
        component?.inject(this)
        mBinding?.vm = mViewModel
    }

}