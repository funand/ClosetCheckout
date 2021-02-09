package com.example.minicheckout.main

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minicheckout.checkout.data.models.ClickListener
import com.example.minicheckout.core.utils.Filter.filterProductList
import com.example.minicheckout.checkout.data.models.InvoiceAdapter
import com.example.minicheckout.core.utils.SortTypeEnum
import com.example.minicheckout.core.utils.formatCurrency
import com.example.minicheckout.repository.network.data.Product
import kotlinx.android.synthetic.main.activity_invoice.*
import java.math.BigDecimal

class InvoiceActivity : AppCompatActivity() {

    private val clickListener: ClickListener = this::handleClick

    private var invoiceList = mutableListOf<Product>()
    private lateinit var recyclerView: RecyclerView
    private val adapter = InvoiceAdapter(clickListener)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_invoice)

        invoiceList = intent.getParcelableArrayListExtra("productDataSet") ?: mutableListOf()

        invoice_back_btn.setOnClickListener { onBackPressed() }

        sortInvoiceList()
        initRecyclerView()
        displayTotal()
    }

    private fun initRecyclerView() {
        recyclerView = recyclerview
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        invoiceList.let { adapter.updateInvoice(it) }
    }

    private fun sortInvoiceList() = if (invoiceList.isNullOrEmpty()) {
        Toast.makeText(this, R.string.toast_msg_empty_list, Toast.LENGTH_LONG).show()
    } else {
        invoiceList =
            filterProductList(invoiceList, sortType = SortTypeEnum.BRAND).toMutableList()
    }

    private fun displayTotal() {
        var total = BigDecimal.ZERO
        for (product: Product in invoiceList) {
            total += product.price.toBigDecimal()
        }
        invoice_total.text = formatCurrency(total.toString())
    }

    private fun handleClick(product: Product) {
        if (invoiceList.contains(product)) {
            this.invoiceList.remove(product)
            displayTotal()
            adapter.updateInvoice(invoiceList)
        } else {
            finish()
        }
    }

}

