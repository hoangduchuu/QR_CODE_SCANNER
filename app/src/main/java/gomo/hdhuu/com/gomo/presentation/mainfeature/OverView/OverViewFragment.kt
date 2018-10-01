package gomo.hdhuu.com.gomo.presentation.mainfeature.OverView

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.databinding.FragmentOverViewBinding
import gomo.hdhuu.com.gomo.presentation.base.BaseFragment
import gomo.hdhuu.com.gomo.presentation.mainfeature.root.HomeActivity
import javax.inject.Inject

/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
class OverViewFragment : BaseFragment(), OverViewContract.View {
    val TAG = OverViewFragment::class.java.simpleName
    /**
     * @presenter is the presenter of this fragment
     */
    @Inject
    lateinit var presenter: OverViewContract.Presenter

    /**
     * @mBinding is the biding
     */
    var mBinding: FragmentOverViewBinding? = null

    /**
     *@mViewModel is ViewModel
     */
    @Inject
    lateinit var mViewModel: OverViewModel


    override fun injectDependencies() {
        if (activity is HomeActivity) {
            (activity as HomeActivity).component
                    ?.plus(OverViewContract.Module(this))
                    ?.inject(this)

        }
        mBinding?.vm = mViewModel


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_over_view, container, false)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(TAG, presenter.getName())
        mViewModel.valueone.set(presenter.getName())
    }
}