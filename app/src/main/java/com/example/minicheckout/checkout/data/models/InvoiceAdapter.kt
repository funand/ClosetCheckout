package com.example.minicheckout.checkout.data.models

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minicheckout.core.utils.formatCurrency
import com.example.minicheckout.main.R
import com.example.minicheckout.repository.network.data.Product
import kotlinx.android.synthetic.main.invoice_item.view.*
import kotlin.random.Random

class InvoiceAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<InvoiceAdapter.InvoiceViewHolder>() {

    private var productList = emptyList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvoiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.invoice_item, parent, false)

        return InvoiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: InvoiceViewHolder, position: Int) {
        val product = productList[position]
        holder.itemView.setBackgroundColor(randomColor())
        holder.bind(product)
        holder.itemView.setOnClickListener { clickListener(product) }
//        holder.itemView.setOnClickListener { clickListener(productList[holder.adapterPosition]) }
    }

    fun updateInvoice(productList: List<Product>) {
        this.productList = productList
        notifyDataSetChanged()
    }

    private fun randomColor() = Color.rgb(
        Random.nextInt(100) + 45,
        Random.nextInt(150) + 44,
        Random.nextInt(1650) + 30
    )


    override fun getItemCount() = productList.count()

    class InvoiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(products: Product) {
            itemView.invoice_price.text = formatCurrency(products.price)
            itemView.invoice_name.text = products.name
            itemView.invoice_brand.text = products.brand
            itemView.setBackgroundColor(randomColor())
        }

        private fun randomColor() = Color.rgb(
            Random.nextInt(100) + 45,
            Random.nextInt(150) + 44,
            Random.nextInt(1650) + 30
        )
    }

}