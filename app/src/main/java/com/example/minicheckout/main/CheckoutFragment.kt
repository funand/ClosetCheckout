package com.example.minicheckout.main

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minicheckout.checkout.data.models.ClickListener
import com.example.minicheckout.checkout.data.models.CheckoutAdapter
import com.example.minicheckout.repository.network.data.BoxResponse
import com.example.minicheckout.repository.network.data.Product
import kotlinx.android.synthetic.main.fragment_checkout.view.*
import kotlin.collections.ArrayList

class CheckoutFragment : Fragment() {

    private var boxResponse: BoxResponse? = null
    private val clickListener: ClickListener = this::handleClick
    private val adapter = CheckoutAdapter(clickListener)
    private val productDataSet = mutableListOf<Product>()
    private lateinit var recyclerView: RecyclerView

    companion object {

        @JvmStatic
        fun newInstance() = CheckoutFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            boxResponse = it.getParcelable("boxResponse")
            boxResponse?.shipment_items?.get(0)?.name?.let { name -> Log.d("TAG", name) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(
            R.layout.fragment_checkout,
            container, false
        )

        rootView.checkout_btn.text =
            requireContext().getText(R.string.purchaseflow_check_out)
        rootView.checkout_btn.setOnClickListener { startInvoice() }
        recyclerView = rootView.recycler_view
        initRecycleView()
        return rootView
    }


    private fun initRecycleView() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        boxResponse?.shipment_items?.let {
            Log.d("FIRST ITEM TAG::", it[0].name)
            displayShipmentList(it)
        }
    }

    private fun displayShipmentList(shipmentList: List<Product>) {
        if (shipmentList.isNotEmpty()) {
            adapter.updateProducts(shipmentList)
        } else {
            Toast.makeText(
                requireContext(),
                R.string.toast_msg_empty_list,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun handleClick(product: Product) {
        Log.d("Product selected", product.name)
        if (productDataSet.contains(product)) {
            productDataSet.remove(product)
        } else {
            productDataSet.add(product)
        }

        Toast.makeText(
            requireContext(),
            "Added: ${product.name}, that's an excellent choice",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun startInvoice() {
        val intent = Intent(activity, InvoiceActivity::class.java)
        val productArrayList: ArrayList<Product> = ArrayList(productDataSet.size)
        productArrayList.addAll(productDataSet)

        intent.putParcelableArrayListExtra(
            "productDataSet",
            productDataSet as ArrayList<out Parcelable>
        )
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        productDataSet.clear()
    }

}