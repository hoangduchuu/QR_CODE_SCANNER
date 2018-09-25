package gomo.hdhuu.com.gomo.presentation.base

import android.support.v4.app.Fragment

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
open class BaseFragment : Fragment(), BaseView {
    override fun showSussessMessages(msg: String?, title: String?) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showSussessMessages(msg,title)
    }

    override fun showWarningMessage(msg: String?, title: String?) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showWarningMessage(msg, title)
    }

    override fun showErrorMessage(msg: String?, title: String?) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showErrorMessage(msg, title)
    }

    override fun showLoadingMessage(msg: String?, title: String?, cancellable: Boolean) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showLoadingMessage(msg, title, cancellable)
    }

    override fun showLoadingMessage(msg: String?, title: String?) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showLoadingMessage(msg, title)
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