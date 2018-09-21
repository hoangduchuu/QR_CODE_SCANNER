package gomo.hdhuu.com.gomo.presentation.base

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
interface BaseView {
    fun showDialog(msg: String)
    fun showDialog(title: String, msg: String)
    fun showDialog(title: String, msg: String, cancelable: Boolean)
}