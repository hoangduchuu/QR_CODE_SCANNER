package gomo.hdhuu.com.gomo.presentation.login.register

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.databinding.FragmentRegisterBinding
import gomo.hdhuu.com.gomo.presentation.base.BaseFragment
import gomo.hdhuu.com.gomo.presentation.login.LoginActivity
import gomo.hdhuu.com.gomo.presentation.login.LoginContract
import gomo.hdhuu.com.gomo.presentation.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
class RegisterFragment : BaseFragment(), RegisterContract.View {
    override fun injectDependencies() {
        if (activity is LoginActivity) {
            (activity as LoginActivity).component
                    ?.plus(RegisterContract.Module(this))
                    ?.inject(this)
            mBinding?.vm = mViewModel
            mBinding?.parenPresenter = parentPresenter
        }
    }

    override fun onRegisterFailed(msg: String) {
        showErrorMessage(msg, getString(R.string.register_error))
    }

    @Inject
    lateinit var mPresenter: RegisterContract.Persenter

    @Inject
    lateinit var parentPresenter: LoginContract.Presenter
    var mBinding: FragmentRegisterBinding? = null
    @Inject
    lateinit var mViewModel: LoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return mBinding?.root
    }


    override fun onRegisterSuccess() {
        parentPresenter.gotoMainPage()
    }


    @OnClick(R.id.btnSubmitRegister)
    fun onRegisterCliked() {
        val user = tvUser.text.toString().trim()
        val password = tvPassword.text.toString().trim()
        mPresenter.register(user, password)
    }
}