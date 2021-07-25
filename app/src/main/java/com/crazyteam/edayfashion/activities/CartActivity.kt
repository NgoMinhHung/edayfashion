package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.crazyteam.edayfashion.R
import kotlinx.android.synthetic.main.activity_transaction_cart.*
import org.jetbrains.anko.toast

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_cart)

        setUpActionBar()

        val activity = mutableListOf(
            Product(0,"Áo sơ mi", 50000, 70000, 60000),
            Product(1,"Áo pull", 50000, 60000, 60000),
            Product(2,"Áo thun", 50000, 50000, 50000)
        )

        val adapter = ActivityAdapterCart()
        rvTransactionsCart.adapter = adapter
        rvTransactionsCart.layoutManager = LinearLayoutManager(this)
        adapter.setActivity(activity)

        btnOrder.setOnClickListener {
            toast("Đặt hàng thành công")
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
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
}