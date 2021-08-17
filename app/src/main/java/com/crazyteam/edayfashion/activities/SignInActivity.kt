package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.SignInParams
import com.crazyteam.edayfashion.models.SignInResponse
import com.crazyteam.edayfashion.services.ApiService
import com.crazyteam.edayfashion.utils.isNotNullOrEmpty
import com.crazyteam.edayfashion.utils.saveAuthInformation
import com.crazyteam.edayfashion.widgets.LoadingDialog
import com.crazyteam.edayfashion.services.implementations.AuthService
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.jetbrains.anko.toast

class SignInActivity : AppCompatActivity() {

    private var email: String? = null

    private var password: String? = null

    lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        init()
    }

    private fun init() {
        loadingDialog = LoadingDialog(this, R.string.signing_in_message)

        btnSignIn.setOnClickListener {
            doSignIn()
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

        tvCreateAccount.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun doSignIn() {
        doIfValid { email, password ->
            val signInParams = SignInParams(
                email = email,
                password = password
            )

            loadingDialog.show()

//            if(email == "thanh@gmail.com"){
//                if(password == "123"){
//                    toast(getString(R.string.sign_in_success_message))
//                    startActivity(Intent(this, MainActivity::class.java))
//                    finish()
//                } else {
//                    toast("Đăng nhập không thành công")
//                }
//            }

            val observable = AuthService.signIn(signInParams)

            ApiService.call(
                observable = observable,
                onSuccess = this@SignInActivity::onSignInSuccess,
                onError = this@SignInActivity::onSignInFailed
            )
        }
    }

    private fun onSignInSuccess(signInResponse: SignInResponse) {
        loadingDialog.dismiss()

        toast(getString(R.string.sign_in_success_message))
        saveAuthInformation(signInResponse)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun onSignInFailed(message: String?) {
        loadingDialog.dismiss()

        showError(message)
    }

    private fun showError(message: String?, clearPassword: Boolean = true) {
        tilEmail.error = message

        if (clearPassword) {
            edtPassword.setText("")
        }
    }

    private fun doIfValid(action: (String, String) -> Unit) {
        email?.let { email ->
            password?.let { password ->
                action.invoke(email, password)
            }
        }
    }

    private fun updateViews() {
        btnSignIn.isEnabled = email.isNotNullOrEmpty() && password.isNotNullOrEmpty()
    }

}