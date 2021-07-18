package com.crazyteam.edayfashion.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.User
import kotlinx.android.synthetic.main.activity_profile.*
import org.jetbrains.anko.toast

class ProfileActivity : AppCompatActivity() {

    private var user: User? = null
    private val defaultImageUrl = "https://scontent-hkg4-1.xx.fbcdn.net/v/t1.18169-1/p160x160/23795862_940775862736131_6197913585812136520_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=7206a8&_nc_ohc=neUEPbO8UTAAX98GwGN&_nc_ht=scontent-hkg4-1.xx&oh=345a45c2b857e702f89aa5b956c394d1&oe=60F992CF"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()

    }

    private fun getUserProfile() {
        display(User(1, "Thanh", "Nguyễn Lương Bằng", false,"0985088304",""))
//        val observable = UserService.getUser(this)
//        showLoading()
//        ApiService.call(
//            observable = observable,
//            onSuccess = this@ProfileActivity::onGetUserSuccess,
//            onError = this@ProfileActivity::onGetUserFailed
//        )
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


    private fun display(user: User) {
        tvName.text =   user.name
        tvGender.text =  getString(if (user.gender) R.string.male else R.string.female)
        tvPhone.text =  user.phone
        tvAddress.text = user.address
        Glide.with(this).load(user.imageUrl ?: defaultImageUrl).into(imgAvatar)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == IntentKeys.UpdateUserFlag && resultCode == Activity.RESULT_OK) {
//            getUserProfile()
//        }
//    }

}