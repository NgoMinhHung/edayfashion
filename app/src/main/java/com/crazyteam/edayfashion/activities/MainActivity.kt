package com.crazyteam.edayfashion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crazyteam.edayfashion.R
import kotlinx.android.synthetic.main.activity_transaction.*

data class Product(val name: String, val amount: Int, val priceBuy: Int, val priceSale: Int)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val activity = mutableListOf(
            Product("Áo sơ mi", 100000, 150000, 90000),
            Product("Áo pull", 100000, 110000, 70000),
            Product("Áo thun", 100000, 150000, 100000)
        )
        val adater = ActivityAdapter()
        rvTransactions.adapter = adater
        adater.setActivity(activity)
    }
}
