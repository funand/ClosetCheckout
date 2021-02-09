package com.example.minicheckout.repository.network.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Using Moshi - we do not need to declare unless casting to new names
@Parcelize
data class Product(
    val id: Long,
    val name: String,
    val price: String,
    val brand: String,
    val image_url: String,
    val size: String
) : Parcelable