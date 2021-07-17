package com.crazyteam.edayfashion.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazyteam.edayfashion.R

class CartActivityAdapter : RecyclerView.Adapter<CartViewHolder>(){

    private val activity = mutableListOf<cart>()

    var onItemClick: ((cart) -> Unit) ? = null
    fun setActivity(input: MutableList<cart>){
        activity.clear()
        activity.addAll(input)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return activity.count()
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.activity = activity[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cartitem_transaction, parent, false)
        return CartViewHolder(view).also {
            it.onClick = this.onItemClick
        }
    }

}