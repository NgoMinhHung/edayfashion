package com.crazyteam.edayfashion.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.fragments.HomeFragment
import com.crazyteam.edayfashion.utils.deleteAuthInformation
import com.minhhung.life_app.fragments.AppreciateFragment
import com.minhhung.life_app.fragments.FavourousFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_transaction.*
import kotlinx.android.synthetic.main.item_transaction.*

data class Product(var id: Int, val name: String, val amount: Int, val priceBuy: Int, val priceSale: Int)

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()

    private val statisticsFragment = FavourousFragment()

    private val settingFragment = AppreciateFragment()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.actionHome -> {
                    showFragment(homeFragment)
                    true
                }

                R.id.actionStatistics -> {
                    showFragment(statisticsFragment)
                    true
                }

                R.id.actionSetting -> {
                    showFragment(settingFragment)
                    true
                }

                else -> false
            }
        }

        showFragment(homeFragment)
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack("")
            commit()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_cart -> {
                Toast.makeText(this, "Đã chọn giỏ hàng", Toast.LENGTH_SHORT).show();
                startActivity(Intent(this, CartActivity::class.java))
                true
            }
            R.id.item_log_out -> {
                Toast.makeText(
                    this,
                    getString(R.string.log_out_success_message),
                    Toast.LENGTH_SHORT
                ).show()
                doLogout()
                true
            }
            R.id.item_profile -> {
                showProfile()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun doLogout() {
        deleteAuthInformation()
        startActivity(Intent(this, SignInActivity::class.java))
        finish()
    }
    private fun showProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

}
