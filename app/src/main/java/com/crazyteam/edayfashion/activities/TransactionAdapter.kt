package com.crazyteam.edayfashion.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.Transaction

class TransactionAdapter : RecyclerView.Adapter<TransactionViewHolder>(){

    private val transactions = mutableListOf<Transaction>()

    var onItemClick: ((Transaction) -> Unit) ? = null
    fun setTransactions(input: MutableList<Transaction>){
        transactions.clear()
        transactions.addAll(input)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return transactions.count()
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.activity = transactions[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return TransactionViewHolder(view).also {
            it.onClick = this.onItemClick
        }
    }

}