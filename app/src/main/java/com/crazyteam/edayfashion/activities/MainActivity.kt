package com.crazyteam.edayfashion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crazyteam.edayfashion.R
import kotlinx.android.synthetic.main.activity_transaction.*
import kotlinx.android.synthetic.main.item_transaction.*

data class Product(var id: Int, val name: String, val amount: Int, val priceBuy: Int, val priceSale: Int)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val activity = mutableListOf(
            Product(0,"Áo sơ mi", 100000, 150000, 90000),
            Product(1,"Áo pull", 100000, 110000, 70000),
            Product(2,"Áo thun", 100000, 150000, 100000)
        )
        val adater = ActivityAdapter().also {
            it.onItemClick = {product ->
                var intent = Intent(this, ActivityDetail::class.java)
                intent.putExtra("ID", product.id)
                startActivity(intent)
            }
        }
        rvTransactions.adapter = adater
        adater.setActivity(activity)
    }

}
