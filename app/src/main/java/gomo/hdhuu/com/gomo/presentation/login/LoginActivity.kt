package gomo.hdhuu.com.gomo.presentation.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.NonNull
import android.widget.Toast
import butterknife.ButterKnife
import com.hnam.mvvm.replaceFragmentInActivity
import gomo.hdhuu.com.gomo.GomoApp
import gomo.hdhuu.com.gomo.R
import gomo.hdhuu.com.gomo.databinding.ActivityLoginBinding
import gomo.hdhuu.com.gomo.presentation.base.BaseActivity
import gomo.hdhuu.com.gomo.presentation.login.register.RegisterFragment
import gomo.hdhuu.com.gomo.presentation.mainfeature.root.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject
import android.support.v7.widget.RecyclerView
import gomo.hdhuu.com.gomo.models.Color
import vn.tiki.noadapter2.OnlyAdapter
import java.util.*
import gomo.hdhuu.com.gomo.R.id.rvList
import android.support.v7.widget.GridLayoutManager
import vn.tiki.noadapter2.databinding.BindingBuilder
import vn.tiki.noadapter2.DiffCallback
import gomo.hdhuu.com.gomo.presentation.home.MainActivity
import android.databinding.ViewDataBinding
import android.support.v4.app.FragmentActivity
import android.system.Os.remove
import android.util.Log
import android.view.View
import vn.tiki.noadapter2.OnItemClickListener
import vn.tiki.noadapter2.databinding.ExtraBinding
import vn.tiki.noadapter2.databinding.LayoutFactory
import kotlin.collections.ArrayList


/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class LoginActivity : BaseActivity(), LoginContract.View {
    override fun onLoginErrors(msg: String) {
        showErrorMessage(msg, getString(R.string.login_falied))
    }

    val TAG = this.javaClass.simpleName
    var mBinding: ActivityLoginBinding? = null

    @Inject
    lateinit var mViewModel: LoginViewModel
    var component: LoginContract.Component? = null

    /**
     * nodadapter only
     */

    private var adapter: OnlyAdapter? = null
    private var items = arrayListOf<String>("x", "y", "z")
    private
    val TAG1 = "MainActivity"
    private val RANDOM = Random()


    override fun gotoMainPage() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()

    }

    @Inject
    lateinit var mPresenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnLogin.setOnClickListener { doLogin() }
        btnRegister.setOnClickListener { openRegister() }

        btAdd.setOnClickListener { addItem() }
        btClear.setOnClickListener { clearItems() }
        btChange.setOnClickListener { shuffleItems() }
        btClear.setOnLongClickListener({v-> removez()})

        val rvList = this.findViewById(R.id.rvList) as RecyclerView

        rvList.layoutManager = GridLayoutManager(
                this,
                5,
                GridLayoutManager.VERTICAL,
                false)
        rvList.setHasFixedSize(true)

        adapter = BindingBuilder()
                .layoutFactory { it ->
                    R.layout.item_text
                }
                .extraBinding { binding, item, position ->
                    Log.d(
                            TAG1,
                            "onBind() called with: binding = ["
                                    + binding
                                    + "], item = ["
                                    + item
                                    + "], position = ["
                                    + position
                                    + "]")
                }
                .onItemClickListener { view, item, position ->
                    Toast.makeText(applicationContext, "Clicked on item: $item", Toast.LENGTH_SHORT)
                            .show()
                }
                .diffCallback(object : DiffCallback {
                    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                        return if (oldItem is Color) {
                            !(newItem !is Color || oldItem.id !== newItem.id)
                        } else {
                            oldItem == newItem
                        }
                    }

                    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                        return oldItem == newItem
                    }
                })
                .build()

        rvList.adapter = adapter
        items = cloneItems()
        adapter?.setItems(items);


    }

    private fun removez(): Boolean {
        items.removeAt(2)
        adapter?.setItems(items)
        return true
    }

    private fun cloneItems(): ArrayList<String> {
        val l = arrayListOf<String>("zz")
        for (z in 1..20) {
            z + 1
            l.add("xxkaka $z")
        }
        return l
    }

    private fun shuffleItems() {
        Collections.shuffle(items);
        adapter?.setItems(items);
    }

    private fun clearItems() {
        items.clear()
        adapter?.setItems(items)
    }

    var x = 1
    private fun addItem() {
        x++
        items.add(1, "xxxx ${x}" )
        adapter?.setItems(items);
    }

    @NonNull
    private fun randomItem(i: Int): Any {
        val item: Any
        if (i % 3 == 0) {
            item = "Text $i"
        } else {
            item = Color(i, randomColor())
        }
        return item
    }

    private fun randomColor(): Int {
        val r = RANDOM.nextInt(256)
        val g = RANDOM.nextInt(256)
        val b = RANDOM.nextInt(256)

        return android.graphics.Color.rgb(r, g, b)
    }

    private fun openRegister() {
        this.replaceFragmentInActivity(RegisterFragment(), R.id.container)
    }


    override fun initializeView(savedInstanceState: Bundle?) {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        ButterKnife.bind(this, mBinding!!.root)

    }

    fun doLogin() {
        mPresenter.doLogin(tvUser.text.trim().toString(), tvPassword.text.trim().toString())
    }

    override fun injectDependencies() {
        component = (application as GomoApp).appComponent
                .plus(LoginContract.Module(this))
        component?.inject(this)
        mBinding?.vm = mViewModel
        mPresenter.checkUserLogged()
    }

}