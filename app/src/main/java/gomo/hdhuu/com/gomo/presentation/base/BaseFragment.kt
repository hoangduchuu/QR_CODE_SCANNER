package gomo.hdhuu.com.gomo.presentation.base

import android.support.v4.app.Fragment

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
open class BaseFragment : Fragment(), BaseView {
    override fun showloadingwithMsg(msg: String?, title: String?, type: Int, cancellable: Boolean) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showloadingwithMsg(msg, title, type, cancellable)
    }

    override fun showloadingwithMsg(msg: String?, title: String?, type: Int) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showloadingwithMsg(msg, title, type)
    }

    override fun showLoading(msg: String?, title: String?) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showLoading(msg, title)
    }

    override fun showLoading() {
        if (activity is BaseActivity)
            (activity as BaseActivity).showLoading()
    }

    override fun hideLoading() {
        if (activity is BaseActivity)
            (activity as BaseActivity).hideLoading()
    }

}