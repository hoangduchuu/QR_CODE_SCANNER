package gomo.hdhuu.com.gomo.models

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable


/**
 * Created by hoangduchuuvn@gmail.com on 10/5/18 .
 */
class Color(val id: Int, val value: Int) {

    fun drawable(): Drawable {
        return ColorDrawable(value)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val color = o as Color?

        return if (id != color!!.id) false else value == color.value

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + value
        return result
    }

    override fun toString(): String {
        return ("Color{"
                + "id="
                + id
                + '}'.toString())
    }
}