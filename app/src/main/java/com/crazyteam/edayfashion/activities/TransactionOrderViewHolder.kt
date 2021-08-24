package com.crazyteam.edayfashion.activities

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.crazyteam.edayfashion.models.AddCartData
import com.crazyteam.edayfashion.utils.isNotNullOrEmpty
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_transaction_cart.*

class TransactionOrderViewHolder(override val containerView: View?) :
    RecyclerView.ViewHolder(containerView!!), LayoutContainer {
    val defaultImageUrl = "https://canifa.com/blog/wp-content/uploads/2017/03/xan-ao-so-mi2.jpg"
    var activity: AddCartData? = null
        set(value) {
            field = value
            display()
        }

    fun display() {
        activity?.apply {
            tvAmountCart.text = amount.toInt().toString()
            tvPriceBuyCart.text = price.toInt().toString()
            tvNameCart.text = if(activity!!.product.name.isNotNullOrEmpty()) activity!!.product.name else "No name"
            Glide.with(containerView!!).load(activity!!.product.imageUrl ?: defaultImageUrl).into(imgProduct)
//            edtCountCart.setText("1")
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