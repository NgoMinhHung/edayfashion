package com.crazyteam.edayfashion.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.crazyteam.edayfashion.R
import com.crazyteam.edayfashion.models.*
import com.crazyteam.edayfashion.services.ApiService
import com.crazyteam.edayfashion.services.implementations.TransactionService
import com.crazyteam.edayfashion.utils.isNotNullOrEmpty
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.toast

class ActivityDetail : AppCompatActivity() {

    private var transaction: Transaction? = null
    private var dataAddCartTransaction: AddCartData? = null
    val defaultImageUrl = "https://canifa.com/blog/wp-content/uploads/2017/03/xan-ao-so-mi2.jpg"
    private var proId: Int? = null
    private var amount: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra("ID", 0)
        proId = id

        init(id)
    }

    private fun init(id: Int) {
        getTransactionDetail(id)   // call api get transaction

        setUpActionBar()

        btnAddCart.setOnClickListener {
            doAddCart()
        }

        edtCount.onTextChanged {
            amount = it.toInt()

            if(it != null && transaction != null){
                tvTotalPrice.text = (transaction!!.price_buy * amount).toString()
            }
//            updateAmount()
        }

    }

    private fun getTransactionDetail(id: Int) {

        val observable = TransactionService.getTransactionDetail(id)

        ApiService.call(
            observable = observable,
            onSuccess = this@ActivityDetail::onGetTransactionSuccess,
            onError = this@ActivityDetail::onGetTransactionFailed
        )
    }

    private fun onGetTransactionSuccess(getTransactionDetailResponse: GetTransactionDetailResponse) {
        transaction = getTransactionDetailResponse.data
        if(getTransactionDetailResponse.data != null) display(getTransactionDetailResponse.data)
    }
    private fun onGetTransactionFailed(message: String?) {
        toast(getString(R.string.load_transaction_detail_failed_message))
    }
    private fun display(transaction: Transaction) {
        var count = 1

        Glide.with(this).load(transaction.imageUrl ?: defaultImageUrl).into(imgProduct)
        tvAmount.text = transaction.amount.toString()
        tvPriceBuy.text = transaction.price_buy.toString()
        tvPriceSale.text = transaction.price_sell.toString()
        tvName.text = transaction.name
        tvTotalPrice.text = (transaction.price_buy * amount).toString()
        edtCount.setText("1")

        toast("Lấy dữ liệu sản phảm thành công")
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

    private fun doAddCart() {
        val addCartTransactionParams = AddCartTransactionParams(
            proId = proId!!,
            amount = amount!!
        )
        AddCartTransaction(addCartTransactionParams)
//        Toast.makeText(this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
    }

    private fun AddCartTransaction(addCartTransactionParams: AddCartTransactionParams) {

        val observable = TransactionService.addCartTransaction(addCartTransactionParams)

        ApiService.call(
            observable = observable,
            onSuccess = this@ActivityDetail::AddCartTransactionSuccess,
            onError = this@ActivityDetail::AddCartTransactionFailed
        )
    }
    private fun AddCartTransactionSuccess(addCartTransactionResponse: AddCartTransactionResponse) {
        dataAddCartTransaction = addCartTransactionResponse.data
        toast(getString(R.string.add_cart_success_message))
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun AddCartTransactionFailed(message: String?) {
        toast(getString(R.string.add_cart_failed_message))
    }

    private fun updateAmount() {
        btnAddCart.isEnabled = !amount.toString().isNotNullOrEmpty() && !proId.toString().isNotNullOrEmpty()
    }
}