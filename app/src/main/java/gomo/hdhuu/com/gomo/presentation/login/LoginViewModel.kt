package gomo.hdhuu.com.gomo.presentation.login

import android.databinding.ObservableBoolean
import android.databinding.ObservableField

/**
 * Created by hoangduchuuvn@gmail.com on 9/24/18 .
 */
class LoginViewModel {
    val buttonVisible = ObservableBoolean(true)
    val status = ObservableField("status be over here")

}