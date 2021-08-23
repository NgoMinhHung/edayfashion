package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.crazyteam.edayfashion.activities.Product
import com.crazyteam.edayfashion.models.Transaction
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_transaction.*
import org.jetbrains.anko.toast

class TransactionViewHolder(override val containerView: View?) :
    RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    var activity: Transaction? = null
        set(value) {
            field = value
            display()
        }

    private fun display() {
        activity?.apply {
            tvName.text = name
            tvAmount.text = amount.toInt().toString()
            tvPriceBuy.text = price_buy.toInt().toString()
            tvPriceSale.text = price_sell.toInt().toString()
        }
    }

    var onClick: ((Transaction) -> Unit)? = null

    init {
        itemView.setOnClickListener {
            activity?.let {
                onClick?.invoke(it)
            }

        }
    }
}