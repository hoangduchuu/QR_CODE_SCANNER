package gomo.hdhuu.com.gomo.presentation.base

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog
import gomo.hdhuu.com.gomo.R

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
abstract class BaseActivity : AppCompatActivity() {

    var dialog: SweetAlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView(savedInstanceState)
        injectDependencies()
        ButterKnife.bind(this)
    }

    protected abstract fun initializeView(savedInstanceState: Bundle?)
    protected abstract fun injectDependencies()


    fun showloadingwithMsg(msg: String?, title: String?, type: Int, cancellable: Boolean = false) {
        if (dialog == null) {
            dialog = SweetAlertDialog(this, type)
        }
        dialog?.setCancelable(cancellable)
        dialog?.titleText = title
        dialog?.contentText = msg
        dialog?.show()

    }

    fun showloadingwithMsg(msg: String?, title: String?, type: Int) {
        if (dialog == null) {
            dialog = SweetAlertDialog(this, type)
        }
        dialog?.titleText = title
        dialog?.contentText = msg
        dialog?.show()

    }

    fun showLoading(msg: String?, title: String?) {
        if (dialog == null) {
            dialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
        }

        dialog?.setTitleText(title)
        dialog?.setContentText(msg)
        dialog?.show()

    }

    fun showLoading() {
        if (dialog == null) {
            dialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
        }
        dialog?.titleText = getString(R.string.loading)
        dialog?.setContentText("")
        dialog?.show()
    }

    fun hideLoading() {
        if (dialog != null) {
            dialog?.hide()
        }
    }


}