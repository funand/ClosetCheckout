package com.example.minicheckout.repository.network.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BoxResponse(
    val id: Long,
    @SerializedName("shipment_items")
    val shipment_items: List<Product>
) : Parcelable

