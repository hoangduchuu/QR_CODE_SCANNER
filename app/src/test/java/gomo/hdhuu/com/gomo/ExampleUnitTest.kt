package gomo.hdhuu.com.gomo

import com.google.firebase.auth.AuthResult
import gomo.hdhuu.com.gomo.R.string.login
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsecaseWithFirebase
import gomo.hdhuu.com.gomo.presentation.login.LoginActivity
import gomo.hdhuu.com.gomo.presentation.login.LoginContract
import gomo.hdhuu.com.gomo.presentation.login.LoginPresenter
import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var mPresenter: LoginContract.Presenter
    private lateinit var view: LoginContract.View
    private lateinit var login: LoginUsecaseWithFirebase
    private lateinit var auth: AuthResult
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = mock(LoginPresenter::class.java)
        view = mock(LoginActivity::class.java)
        login = mock(LoginUsecaseWithFirebase::class.java)
        auth = mock(AuthResult::class.java)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        `when`(mPresenter.doLogin("a@a.vn", "123456"))
        mPresenter.checkUserLogged()
        verify(view).gotoMainPage()
    }
}
