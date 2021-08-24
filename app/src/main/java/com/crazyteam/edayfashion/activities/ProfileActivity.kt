package com.crazyteam.edayfashion.activities


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.GetUserResponse
import com.crazyteam.edayfashion.models.User
import com.crazyteam.edayfashion.services.ApiService
import com.crazyteam.edayfashion.services.implementations.UserService
import com.crazyteam.edayfashion.utils.Constants.IntentKeys
import kotlinx.android.synthetic.main.activity_profile.*
import org.jetbrains.anko.toast

class ProfileActivity : AppCompatActivity() {

    private var user: User? = null
    private val defaultImageUrl = "https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()

    }

    private fun getUserProfile() {
//        display(User(1, "Thanh", "Nguyễn Lương Bằng", false,"0985088304",""))
        val observable = UserService.getUser()

        ApiService.call(
            observable = observable,
            onSuccess = this@ProfileActivity::onGetUserSuccess,
            onError = this@ProfileActivity::onGetUserFailed
        )
    }

    private fun setUpActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }

    private fun init() {
        getUserProfile()

        setUpActionBar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.user_profile_options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_edit_profile -> {
                user?.apply {
                    val intent =
                        Intent(this@ProfileActivity, EditProfileActivity::class.java).apply {
                            putExtra(IntentKeys.UserName, username)
                            putExtra(IntentKeys.UserGender, sex)
                            putExtra(IntentKeys.UserPhoneNumber, phone)
                            putExtra(IntentKeys.UserImageUrl, imageUrl)
                            putExtra(IntentKeys.UserAddress, addr)
                        }
                    startActivityForResult(intent, IntentKeys.UpdateUserFlag)
//                    startActivity(intent)
                }
//                var intent = Intent(this, EditProfileActivity::class.java)
//                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun display(user: User) {
        tvName.text = user.username
        tvGender.text = getString(if (user.sex) R.string.male else R.string.female)
        tvPhone.text =  user.phone
        tvAddress.text = user.addr
        Glide.with(this).load(user.imageUrl ?: defaultImageUrl).into(imgAvatar)
        toast("Lấy thông tin thành công")
    }

    private fun onGetUserSuccess(getUserResponse: GetUserResponse) {
        user = getUserResponse.data
        if(getUserResponse.data != null) display(getUserResponse.data)
    }
    private fun onGetUserFailed(message: String?) {
        toast(getString(R.string.load_user_profile_failed_message))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            getUserProfile()
    }

}