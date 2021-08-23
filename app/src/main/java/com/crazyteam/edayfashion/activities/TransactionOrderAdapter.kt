package com.crazyteam.edayfashion.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.AddCartData

class TransactionOrderAdapter: RecyclerView.Adapter<TransactionOrderViewHolder>(){

    private val transactionsOrder = mutableListOf<AddCartData>()

//    var onItemClick: ((Product) -> Unit) ? = null

    fun setTransactionOrder(input: MutableList<AddCartData>){
        transactionsOrder.clear()
        transactionsOrder.addAll(input)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return transactionsOrder.count()
    }

    override fun onBindViewHolder(holder: TransactionOrderViewHolder, position: Int) {
        holder.activity = transactionsOrder[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionOrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction_cart, parent, false)
        return TransactionOrderViewHolder(view)
//            .also {
//            it.onClick = this.onItemClick
//        }
    }

}