package gomo.hdhuu.com.gomo.business.accouting

/**
 * Created by hoangduchuuvn@gmail.com on 9/25/18 .
 */
class AccountParams(val email: String, val password: String){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AccountParams

        if (email != other.email) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = email.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}