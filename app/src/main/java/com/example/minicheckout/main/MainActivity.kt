package com.example.minicheckout.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.minicheckout.checkout.data.models.ExampleViewModel
import com.example.minicheckout.extensions.loadCircleCrop
import com.example.minicheckout.repository.network.data.BoxResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_startup_layout.*


class MainActivity : AppCompatActivity() {

    private lateinit var exampleViewModel: ExampleViewModel

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        exampleViewModel = restoreViewModel()

        //Set up Basic page
        profileImage.loadCircleCrop(getString(R.string.user_profileimage))
        profileName.text =
            getString(R.string.user_firstname) + " " + getString(R.string.user_lastname)
        checkoutButton.setOnClickListener {
            exampleViewModel.getBoxResponse()
                .observe(this, Observer { it?.let { startCheckoutActivity(it) } })
        }
    }

    private fun startCheckoutActivity(boxResponse: BoxResponse) {
        Log.d("TAG:::", "After getting response}")

        if (!boxResponse.shipment_items.isNullOrEmpty()) {
            startup_container.visibility = View.GONE
            fragment.visibility = View.VISIBLE

            val bundle = Bundle()
            bundle.putParcelable("boxResponse", boxResponse)

            val checkoutFragment = CheckoutFragment.newInstance()
            checkoutFragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, checkoutFragment)
                .addToBackStack(null)
                .commit()
        } else {
            Toast.makeText(this, R.string.toast_msg_empty_list, Toast.LENGTH_LONG).show()
        }
    }

    private fun restoreViewModel() = ViewModelProvider(this).get(ExampleViewModel::class.java)
}