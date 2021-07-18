package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.crazyteam.edayfashion.activities.Product
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_transaction.*
import org.jetbrains.anko.toast

class ActivityViewHolder(override val containerView: View?) :
    RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    var activity: Product? = null
        set(value) {
            field = value
            display()
        }

    fun display() {
        activity?.apply {
            tvName.text = name
            tvAmount.text = amount.toInt().toString()
            tvPriceBuy.text = priceBuy.toInt().toString()
            tvPriceSale.text = priceSale.toInt().toString()
        }
    }

    var onClick: ((Product) -> Unit)? = null

    init {
        itemView.setOnClickListener {
            activity?.let {
                onClick?.invoke(it)
            }

        }
    }
}