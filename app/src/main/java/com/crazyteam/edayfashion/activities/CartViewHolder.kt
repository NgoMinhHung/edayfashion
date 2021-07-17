package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_transaction.*
import org.jetbrains.anko.toast

class CartViewHolder(override val containerView: View?) :
    RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    var activity: cart? = null
        set(value) {
            field = value
            display()
        }

    fun display() {
        activity?.apply {
            tvName.text = name
            tvAmount.text = size.toString()
            tvPriceBuy.text = priceBuy.toInt().toString()
            tvPriceSale.text = quantity.toInt().toString()
        }
    }

    var onClick: ((cart) -> Unit)? = null

    init {
        itemView.setOnClickListener {
            activity?.let {
                onClick?.invoke(it)
            }

        }
    }
}