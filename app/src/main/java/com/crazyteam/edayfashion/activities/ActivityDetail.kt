package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.crazyteam.edayfashion.R
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

class ActivityDetail : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("ID", 0)
        val name = intent.getStringExtra("Name")
        val amount = intent.getIntExtra("Amount", 0)
        val priceBuy = intent.getIntExtra("PriceBuy", 0)
        val priceSale = intent.getIntExtra("PriceSale", 0)
        var count = 1

        tvName.text = name.toString()
        tvAmount.text = amount.toString()
        tvPriceBuy.text = priceBuy.toString()
        tvPriceSale.text = priceSale.toString()
        edtCount.setText("1")

        btnAddCart.setOnClickListener {
            doAddCart()
        }
        setUpActionBar()
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

    private fun doAddCart() {
        var intent = Intent(this, MainActivity::class.java)
        Toast.makeText(this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
        startActivity(intent)
    }
}