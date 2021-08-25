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

//    lateinit var adapter: TransactionOrderAdapter

    private val adapter = TransactionOrderAdapter()
    private var sum = 0f;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_cart)

        setUpActionBar()


//        val transactions = mutableListOf(
//            AddCartData(1,"BC","",1,1,2,20000f,null,null,null,0)
//        )

        rvTransactionsCart.adapter = adapter
        rvTransactionsCart.layoutManager = LinearLayoutManager(this)
//        adapter.setTransactionOrder(transactions)

        getTransactionsOrder()

        btnOrder.setOnClickListener {
            toast("Đặt hàng thành công")
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getTransactionsOrder() {
        val observable =
            TransactionService.getListCartTransaction()
        ApiService.call(
            observable = observable,
            onSuccess = ::onGetTransactionsSuccess,
            onError = ::onError
        )
    }

    private fun onGetTransactionsSuccess(getTransactionsResponse: GetOrderListCartTransactionResponse) {
        displayTransactions(getTransactionsResponse.data.listOrder)
    }
    private fun displayTransactions(transactions: MutableList<AddCartData>) {
        adapter.setTransactionOrder(transactions)
        for(i in transactions.indices) sum = sum + transactions[i].price
        toast("Lấy dữ liệu danh sách sản phảm thành công")
        tvTotalCart.text = sum.toString()
    }
    private fun onError(string: String?) {
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