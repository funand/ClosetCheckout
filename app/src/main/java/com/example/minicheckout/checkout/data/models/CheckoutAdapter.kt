package com.example.minicheckout.checkout.data.models

import android.app.Activity
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.minicheckout.core.utils.ItemDiffCallback
import com.example.minicheckout.core.utils.formatCurrency
import com.example.minicheckout.main.R
import com.example.minicheckout.repository.network.data.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_items.view.*


typealias ClickListener = (Product) -> Unit

class CheckoutAdapter(private val clickListener: ClickListener) :
    RecyclerView.Adapter<CheckoutAdapter.ProductViewHolder>() {

    private var productList = emptyList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_items, parent, false)
        val viewHolder = ProductViewHolder(view)
        view.setOnClickListener { clickListener(productList[viewHolder.adapterPosition]) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    fun updateProducts(productList: List<Product>) {
        val diffResult = DiffUtil.calculateDiff(ItemDiffCallback(this.productList, productList))
        this.productList = productList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = productList.count()

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(products: Product) {
            Picasso.get().load(products.image_url).fit().into(itemView.product_image as ImageView)

            itemView.checkout_price.text = formatCurrency(products.price)
            itemView.checkout_name.text = products.name
            itemView.checkout_brand.text = products.brand

        }
    }

}