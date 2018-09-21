package gomo.hdhuu.com.gomo.models

import android.databinding.ObservableBoolean
import android.databinding.ObservableField

/**
 * Created by hoangduchuuvn@gmail.com on 9/22/18 .
 */
class DemoViewModel {
     val buttonVisible = ObservableBoolean(true)
     val text = ObservableField("Data binding works!")
    val age = ObservableField(1)

    fun buttonClicked() {
        text.set("Button clicked!")
        age.set(age.get()!! + 1)
    }
}