package com.crazyteam.edayfashion.activities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_transaction_cart.*

class ActivityViewHolderCart(override val containerView: View?) :
    RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    var activity: Product? = null
        set(value) {
            field = value
            display()
        }

    fun display() {
        activity?.apply {
            tvNameCart.text = name
            tvAmountCart.text = amount.toInt().toString()
            tvPriceBuyCart.text = priceBuy.toInt().toString()
            tvPriceSaleCart.text = priceSale.toInt().toString()
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