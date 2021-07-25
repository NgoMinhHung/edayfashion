package com.minhhung.life_app.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.activities.ActivityAdapter
import com.crazyteam.edayfashion.activities.ActivityDetail
import com.crazyteam.edayfashion.activities.Product
import kotlinx.android.synthetic.main.activity_transaction.*
import java.util.*

class AppreciateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = mutableListOf(
            Product(0,"Áo dài", 140000, 150000, 90000),
            Product(1,"Áo tứ thân", 120000, 130000, 80000),
            Product(2,"Áo bà ba", 100000, 120000, 70000)
        )
        val adater = ActivityAdapter().also {
            it.onItemClick = {product ->
                var intent = Intent(context!!, ActivityDetail::class.java)
                intent.putExtra("ID", product.id)
                intent.putExtra("Name", product.name)
                intent.putExtra("Amount", product.amount)
                intent.putExtra("PriceBuy", product.priceBuy)
                intent.putExtra("PriceSale", product.priceSale)
                startActivity(intent)
            }
        }
        rvTransactions.adapter = adater
        adater.setActivity(activity)

    }

}