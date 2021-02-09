package com.example.minicheckout.core.utils

import android.icu.text.NumberFormat
import java.util.*

// See https://developer.android.com/reference/kotlin/android/icu/util/Currency
// Defaulting to US currency here (will show up properly regardless of current locale)

fun formatCurrency(price: String): String =
    NumberFormat.getCurrencyInstance(Locale.US).format(price.toBigDecimal())

