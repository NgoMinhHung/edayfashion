package com.crazyteam.edayfashion.fragments

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

class HomeFragment : Fragment() {

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
            Product(0,"Áo sơ mi", 50000, 70000, 60000),
            Product(1,"Áo pull", 50000, 60000, 60000),
            Product(2,"Áo thun", 50000, 50000, 50000)
        )
        val adater = ActivityAdapter().also {
            it.onItemClick = {product ->
                var intent = Intent(context!!, ActivityDetail::class.java)
                intent.putExtra("ID", product.id)
                startActivity(intent)
            }
        }
        rvTransactions.adapter = adater
        adater.setActivity(activity)
    }
}