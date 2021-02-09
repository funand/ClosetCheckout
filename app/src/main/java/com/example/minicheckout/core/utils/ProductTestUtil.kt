package com.example.minicheckout.core.utils

import com.example.minicheckout.repository.network.data.Product

fun getSampleProductList() =
    listOf(
        Product(5L, "Adidas CloudFoam Slides", "25", "Adidas", "n/a", "16"),
        Product(2L, "Nike AirMax", "75", "Nike", "n/a", "15"),
        Product(
            3L,
            "Jeremy Scott x Wings 3.0 Solid Gold",
            "175",
            "Jeremy Scott X Adidas",
            "n/a",
            "15"
        ),
        Product(4L, "Nike Uptempo", "145", "Nike", "n/a", "15"),
        Product(1L, "SCUDERIA FERRARI RACE FUTURE KART X PUMA", "2000", "Puma", "n/a", "15"),
        Product(1L, "Talon", "350", "Giuseppe Zanotti ", "n/a", "16")
    )



