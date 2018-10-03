package gomo.hdhuu.com.gomo.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import butterknife.ButterKnife

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
abstract class BaseFragment : Fragment(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectDependencies()
        ButterKnife.bind(this, view)

    }

    abstract fun injectDependencies()

    override fun showSussessMessages(msg: String?, title: String?) {
        if (activity is BaseActivity)
            (activity as BaseActivity).showSussessMessages(msg, title)
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