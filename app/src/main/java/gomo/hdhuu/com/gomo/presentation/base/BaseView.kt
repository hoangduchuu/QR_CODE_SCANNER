package gomo.hdhuu.com.gomo.presentation.base

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface BaseView {
    fun showLoadingMessage(msg: String?, title: String?, cancellable: Boolean = false)
    fun showLoadingMessage(msg: String?, title: String?)
    fun showErrorMessage(msg: String?, title: String?)
    fun showWarningMessage(msg: String?, title: String?)
    fun showSussessMessages(msg: String?, title: String?)
    fun showLoading(msg: String?, title: String?)
    fun showLoading()
    fun hideLoading()
}