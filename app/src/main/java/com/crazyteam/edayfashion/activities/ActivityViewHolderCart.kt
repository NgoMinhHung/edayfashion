package com.crazyteam.edayfashion.activities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_transaction.*

class ActivityViewHolderCart(override val containerView: View?) :
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

//    var onClick: ((Product) -> Unit)? = null

//    init {
//        itemView.setOnClickListener {
//            activity?.let {
//                onClick?.invoke(it)
//            }
//
//        }
//    }
}