package com.crazyteam.edayfashion.activities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.crazyteam.edayfashion.models.Transaction
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_transaction.*
import kotlinx.android.synthetic.main.item_transaction.imgProduct
import kotlinx.android.synthetic.main.item_transaction.tvAmount
import kotlinx.android.synthetic.main.item_transaction.tvName
import kotlinx.android.synthetic.main.item_transaction.tvPriceBuy
import kotlinx.android.synthetic.main.item_transaction.tvPriceSale
import org.jetbrains.anko.toast

class TransactionViewHolder(override val containerView: View?) :
    RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    val defaultImageUrl = "https://canifa.com/blog/wp-content/uploads/2017/03/xan-ao-so-mi2.jpg"
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
            Glide.with(containerView!!).load(imageUrl ?: defaultImageUrl).into(imgProduct)
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