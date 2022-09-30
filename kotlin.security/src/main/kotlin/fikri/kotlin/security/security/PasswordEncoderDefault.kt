package fikri.kotlin.security.security

import org.springframework.security.crypto.password.PasswordEncoder

class PasswordEncoderDefault: PasswordEncoder {
    override fun encode(rawPassword: CharSequence?): String {
        return rawPassword.toString()
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
        return rawPassword.toString() == encodedPassword
    }
}