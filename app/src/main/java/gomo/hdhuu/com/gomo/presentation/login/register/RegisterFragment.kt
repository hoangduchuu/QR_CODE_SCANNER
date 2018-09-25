package gomo.hdhuu.com.gomo.presentation.login.register

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.databinding.FragmentRegisterBinding
import gomo.hdhuu.com.gomo.presentation.base.BaseFragment
import gomo.hdhuu.com.gomo.presentation.base.BaseView
import gomo.hdhuu.com.gomo.presentation.login.LoginActivity
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
class RegisterFragment : BaseFragment(), RegisterContract.View {

    @Inject
    lateinit var mPresenter: RegisterContract.Persenter
    var mBinding: FragmentRegisterBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        return mBinding?.root
    }

    override fun onRegisterSuccess() {
        ///
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is LoginActivity) {
            (activity as LoginActivity).component
                    ?.plus(RegisterContract.Module(this))
                    ?.inject(this)
        }

        Log.e("HUUHOANG", mPresenter.toString())

    }
}