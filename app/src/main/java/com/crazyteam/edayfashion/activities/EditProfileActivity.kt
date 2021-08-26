package com.crazyteam.edayfashion.activities


import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.UpdateUserParams
import com.crazyteam.edayfashion.models.UpdateUserResponse
import com.crazyteam.edayfashion.services.ApiService
import com.crazyteam.edayfashion.services.implementations.UserService
import com.crazyteam.edayfashion.utils.Constants.IntentKeys
import kotlinx.android.synthetic.main.activity_edit_profile.*
import org.jetbrains.anko.toast

class EditProfileActivity : AppCompatActivity() {


    private var name: String? = null

    private var gender: Boolean = false

    private var address: String? = null

    private var imageUrl: String? = null

    private var phone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        init()
    }

    private fun getIntentData() {
        name = intent.getStringExtra(IntentKeys.UserName)
        gender = intent.getBooleanExtra(IntentKeys.UserGender, false)
        address = intent.getStringExtra(IntentKeys.UserAddress)
        imageUrl = intent.getStringExtra(IntentKeys.UserImageUrl)
        phone = intent.getStringExtra(IntentKeys.UserPhoneNumber)
    }

    private fun init() {

        getIntentData()

        display()

        btnOk.setOnClickListener {
            doUpdate()
        }

        btnCancel.setOnClickListener {
            // Todo Show confirmation dialog
            finish()
        }
    }

    private fun display() {
        edtName.setText(name)
        radioButtonMale.isChecked = gender
        radioButtonFemale.isChecked = !gender
        edtAddress.setText(address)
        edtPhone.setText(phone)
        Glide.with(this).load(imageUrl).into(imgAvatar)
    }

    private fun updateProfile(updateUserParams: UpdateUserParams) {
        val observable = UserService.updateUser(updateUserParams)
        ApiService.call(
            observable = observable,
            onSuccess = this@EditProfileActivity::onUpdateProfileSuccess,
            onError = this@EditProfileActivity::onUpdateProfileFailed
        )
    }

    private fun onUpdateProfileSuccess(updateUserResponse: UpdateUserResponse) {

        updateUserResponse.data.let {
            name = it.first_name + " " + it.last_name
            gender = it.sex
            address = it.addr
            phone = it.phone
            imageUrl = it.imageUrl
        }

        setResult(Activity.RESULT_OK)
        finish()
    }

    private fun onUpdateProfileFailed(message: String?) {
        toast(message.toString())
    }

    private fun doUpdate() {
        name = edtName.text.toString()
        address = edtAddress.text.toString()
        phone = edtPhone.text.toString()
        gender = radioButtonMale.isChecked

        val updateUserParams = UpdateUserParams(
//            username = name.toString(),
            phone = phone.toString(),
            addr = address.toString(),
            birthDay = "1998-09-12",
            sex = if(gender) 1 else 0,
            firstname = name.toString(),
            lastname = ""
        )

        updateProfile(updateUserParams)
    }

}