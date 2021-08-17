package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.SignUpParams
import com.crazyteam.edayfashion.models.SignUpResponse
import com.crazyteam.edayfashion.services.ApiService
import com.crazyteam.edayfashion.services.implementations.AuthService
import com.crazyteam.edayfashion.utils.isNotNullOrEmpty
import com.crazyteam.edayfashion.widgets.LoadingDialog
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.toast

class SignUpActivity : AppCompatActivity () {
    private var name: String? = null

    private var email: String? = null

    private var password: String? = null

    private var confirmPassword: String? = null

    lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()
    }
    private fun init() {
        loadingDialog = LoadingDialog(this, R.string.sign_up_message)

        btnSignUp.setOnClickListener() {
            doSignUp()
        }

        edtName.onTextChanged {
            name = it

            showError(null, clearPassword = false)

            updateViews()
        }

        edtEmail.onTextChanged {
            email = it

            showError(null, clearPassword = false)

            updateViews()
        }
        edtPassword.onTextChanged {
            password = it

            updateViews()
        }

        edtPasswordConfirmation.onTextChanged {
            confirmPassword = it

            updateViews()
        }

        tvLogin.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }

    private fun doSignUp() {
        doIfValid { name, email, password, confirmPassword ->
            val signUpParams = SignUpParams(
                username = name,
                email = email,
                password = password,
                confirmPassword = confirmPassword
            )

            loadingDialog.show()

            val observable = AuthService.signUp(signUpParams)

            ApiService.call(
                observable = observable,
                onSuccess = this@SignUpActivity::onSignUpSuccess,
                onError = this@SignUpActivity::onSignUpFailed
            )
        }
    }

    private fun onSignUpSuccess(signUpResponse: SignUpResponse) {
        loadingDialog.dismiss()

        toast(R.string.created_account_success_message)
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }

    private fun onSignUpFailed(message: String?) {
        loadingDialog.dismiss()

        showError(message)
    }

    private fun showError(message: String?, clearPassword: Boolean = true) {
        tilName.error = message
        tilEmail.error = message

        if (clearPassword) {
            edtPassword.setText("")
            edtPasswordConfirmation.setText("")
        }
    }

    private fun doIfValid(action: (String, String, String, String) -> Unit) {
        name?.let { name ->
            email?.let { email ->
                password?.let { password ->
                    confirmPassword?.let { confirmPassword ->
                        action.invoke(name, email, password, confirmPassword)
                    }
                }
            }
        }
    }

    private fun updateViews() {
        btnSignUp.isEnabled = name.isNotNullOrEmpty() && email.isNotNullOrEmpty() &&
                password.isNotNullOrEmpty() && confirmPassword.isNotNullOrEmpty() && (password == confirmPassword)
    }

}