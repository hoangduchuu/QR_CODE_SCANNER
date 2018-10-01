package gomo.hdhuu.com.gomo.presentation.login

import android.net.Credentials
import android.os.Parcel
import com.google.firebase.auth.AdditionalUserInfo
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import durdinapps.rxfirebase2.RxFirebaseAuth
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsacase
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsecaseWithFirebase
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.subscribers.TestSubscriber
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Inject


/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {
    /**
     * @view is View
     */
    @Inject
    @Mock
    lateinit var mockView: LoginContract.View
    /**
     *@mockFirebaseUser is mockFirebaseUser
     */
    lateinit var mockFirebaseUser: FirebaseUser

    /**
     *@presenter
     */
    @Mock
    lateinit var presenter: LoginPresenter

    /**
     * @mockLogin is loginUsecase
     */
    @Mock
    lateinit var mockLogin: LoginUsacase<AccountParams, AuthResult>


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        mockFirebaseUser = mock(FirebaseUser::class.java)

        presenter = LoginPresenter()

        this.mockLogin = mock(LoginUsecaseWithFirebase::class.java)
        this.mockView = mock(LoginContract.View::class.java)


//        presenter.view = this.mockView
        presenter.login = this.mockLogin


    }


    @Test
    fun whenLloginSuccess() {

        val result = mock(AuthResult::class.java)

        `when`(mockLogin.buildUseCaseObservable(AccountParams("abc", "abc")))
                .thenReturn(Observable.just(result))
        //when
        presenter.doLogin("abc", "abc")


        //verify
        verify(mockView).showLoading()
        verify(mockView).hideLoading()
        verify(mockView).gotoMainPage()
    }

    @Test
    fun whenLloginFailed() {
        val throwables = Throwable("abac")

        `when`(mockLogin.buildUseCaseObservable(AccountParams("abc", "abc")))
                .thenReturn(Observable.error(throwables))
        //when
        presenter.doLogin("abc", "abc")


        //verify
        verify(mockView).showLoading()
        verify(mockView).onLoginErrors(throwables.localizedMessage)

    }


}