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
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by hoangduchuuvn@gmail.com on 9/26/18 .
 */
@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {
    //    var checkLogin = CheckLoginUsecaseWithFirebase()
//
//    lateinit var loginPresenter: LoginPresenter
//
    lateinit var firebaseAuth: FirebaseAuth
    @Mock
    lateinit var view: LoginContract.View
    lateinit var mockFirebaseUser: FirebaseUser
    //lateinit var mockLogin: LoginUsecaseWithFirebase


    @Before
    fun setUp() {
        mockFirebaseUser = mock(FirebaseUser::class.java)

        firebaseAuth = mock(FirebaseAuth::class.java)



    }



    @Test
    fun whenLloginSuccess() {

        val presenter: LoginPresenter = LoginPresenter()

        var mockLogin: LoginUsacase<AccountParams, AuthResult> = mock(LoginUsecaseWithFirebase::class.java)
        var view: LoginContract.View = mock(LoginContract.View::class.java)
        var result = mock(AuthResult::class.java)
        presenter.login = mockLogin
        presenter.view = view

        `when`(mockLogin.buildUseCaseObservable(AccountParams("abc","abc")))
                .thenReturn(Observable.just(result))
        //when
        presenter.doLogin("abc", "abc")


        //verify
        verify(view).showLoading()
        verify(view).hideLoading()
        verify(view).gotoMainPage()
    }

    @Test
    fun whenLloginFailed() {

        val presenter: LoginPresenter = LoginPresenter()

        var mockLogin: LoginUsacase<AccountParams, AuthResult> = mock(LoginUsecaseWithFirebase::class.java)
        var view: LoginContract.View = mock(LoginContract.View::class.java)
        presenter.login = mockLogin
        presenter.view = view


        var throwables = Throwable("abac")

        `when`(mockLogin.buildUseCaseObservable(AccountParams("abc","abc")))
                .thenReturn(Observable.error(throwables))
        //when
        presenter.doLogin("abc", "abc")


        //verify
        verify(view).showLoading()
        verify(view).onLoginErrors(throwables.localizedMessage)

    }


}