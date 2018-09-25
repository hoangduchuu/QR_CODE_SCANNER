package gomo.hdhuu.com.gomo.presentation.base

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface BaseView {
    fun showloadingwithMsg(msg: String?, title: String?, type: Int, cancellable: Boolean = false)
    fun showloadingwithMsg(msg: String?, title: String?, type: Int)
    fun showLoading(msg: String?, title: String?)
    fun showLoading()
    fun hideLoading()
}