package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crazyteam.edayfashion.R
import kotlinx.android.synthetic.main.activity_transaction.*
import kotlinx.android.synthetic.main.activity_transaction_cart.*

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_cart)
        val activity = mutableListOf(
            Product(0,"Áo sơ mi", 50000, 70000, 60000),
            Product(1,"Áo pull", 50000, 60000, 60000),
            Product(2,"Áo thun", 50000, 50000, 50000)
        )
        val adater = ActivityAdapterCart()
        rvTransactionsCart.adapter = adater
        adater.setActivity(activity)
    }
}