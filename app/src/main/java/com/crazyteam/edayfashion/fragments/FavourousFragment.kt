package com.minhhung.life_app.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.activities.TransactionAdapter
import com.crazyteam.edayfashion.activities.ActivityDetail
import com.crazyteam.edayfashion.activities.Product
import com.crazyteam.edayfashion.models.GetTransactionsResponse
import com.crazyteam.edayfashion.models.Transaction
import com.crazyteam.edayfashion.services.ApiService
import com.crazyteam.edayfashion.services.implementations.TransactionService
import kotlinx.android.synthetic.main.activity_transaction.*

class FavourousFragment : Fragment() {

    lateinit var adapter: TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TransactionAdapter().also {
            it.onItemClick = {product ->
                var intent = Intent(context!!, ActivityDetail::class.java)
                intent.putExtra("ID", product.id)
                startActivity(intent)
            }
        }
        rvTransactions.adapter = adapter

        getTransactions()
    }
    private fun getTransactions() {
//        showLoading()
        val observable =
            TransactionService.getTransactions()
        ApiService.call(
            observable = observable,
            onSuccess = ::onGetTransactionsSuccess,
            onError = ::onError
        )
    }
    private fun onGetTransactionsSuccess(getTransactionsResponse: GetTransactionsResponse) {
        displayTransactions(getTransactionsResponse.data)
//        hideLoading()
    }
    private fun displayTransactions(transactions: MutableList<Transaction>) {
        adapter.setTransactions(transactions)
    }
    private fun onError(string: String?) {
//        hideLoading()
    }

}