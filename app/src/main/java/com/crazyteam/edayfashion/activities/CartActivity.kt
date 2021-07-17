package com.crazyteam.edayfashion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crazyteam.edayfashion.R
import kotlinx.android.synthetic.main.activity_transaction.*
import kotlinx.android.synthetic.main.item_transaction.*

data class cart(var id: Int, val name: String, val size: String, val priceBuy: Int, val quantity: Int)

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        val activity = mutableListOf(
            cart(0,"Áo sơ mi", "M", 150000, 90000),
            cart(1,"Áo sơ mi", "M", 150000, 90000)
//            Product(1,"Áo pull", 100000, 110000, 70000),
//            Product(2,"Áo thun", 100000, 150000, 100000)
        )
        val adater = ActivityAdapter().also {
            it.onItemClick = {cart ->
                var intent = Intent(this, ActivityDetail::class.java) /// thiếu 1 activity detail trỏ từ cái layout rồi
                intent.putExtra("ID", cart.id)
                startActivity(intent)
            }
        }
        rvTransactions.adapter = adater
        adater.setActivity(activity)
    }

}
