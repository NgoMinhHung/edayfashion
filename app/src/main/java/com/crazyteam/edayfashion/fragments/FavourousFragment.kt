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
import org.jetbrains.anko.toast

class FavourousFragment : Fragment() {

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
            Product(0,"Áo Kimono", 170000, 150000, 150000),
            Product(1,"Áo Dài VN", 170000, 160000, 160000),
            Product(2,"Áo Hanbok", 170000, 150000, 140000)
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