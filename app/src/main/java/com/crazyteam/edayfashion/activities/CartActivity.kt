package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.AddCartData
import com.crazyteam.edayfashion.models.GetOrderListCartTransactionResponse
import com.crazyteam.edayfashion.services.ApiService
import com.crazyteam.edayfashion.services.implementations.TransactionService
import kotlinx.android.synthetic.main.activity_transaction_cart.*
import org.jetbrains.anko.toast

class CartActivity : AppCompatActivity() {

    lateinit var adapter: TransactionOrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_cart)

        setUpActionBar()

        rvTransactionsCart.adapter = adapter
        rvTransactionsCart.layoutManager = LinearLayoutManager(this)


        getTransactionsOrder()

        btnOrder.setOnClickListener {
            toast("Đặt hàng thành công")
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getTransactionsOrder() {
//        showLoading()
        val observable =
            TransactionService.getListCartTransaction()
        ApiService.call(
            observable = observable,
            onSuccess = ::onGetTransactionsSuccess,
            onError = ::onError
        )
    }

    private fun onGetTransactionsSuccess(getTransactionsResponse: GetOrderListCartTransactionResponse) {
        displayTransactions(getTransactionsResponse.data)
//        hideLoading()
    }
    private fun displayTransactions(transactions: MutableList<AddCartData>) {
        adapter.setTransactionOrder(transactions)
        toast("Lấy dữ liệu danh sách sản phảm thành công")
    }
    private fun onError(string: String?) {
//        hideLoading()
        toast("Lấy dữ liệu danh sách sản phảm lỗi")
    }

    private fun setUpActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}