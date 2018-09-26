package gomo.hdhuu.com.gomo.presentation.login

import android.net.Credentials
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import gomo.hdhuu.com.gomo.business.accouting.AccountParams
import gomo.hdhuu.com.gomo.business.accouting.login.LoginUsecaseWithFirebase
import org.junit.Assert
import org.junit.Before
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
    lateinit var mockLogin: LoginUsecaseWithFirebase
    @Before
    fun setUp() {
        mockFirebaseUser = mock(FirebaseUser::class.java)

        firebaseAuth = mock(FirebaseAuth::class.java)
        firebaseAuth.signInWithEmailAndPassword("a@a.vn", "123456")
        mockLogin = mock(LoginUsecaseWithFirebase::class.java)


    }

    @Test
    fun whenLloginSuccess() {

        firebaseAuth.signInWithEmailAndPassword("a@a.vn", "123456")

        mockLogin.buildUseCaseObservable(AccountParams("a@a.vn", "123456"))
    }
}