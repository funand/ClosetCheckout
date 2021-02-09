package com.example.minicheckout.core.utils

import com.example.minicheckout.repository.network.data.Product

object Filter {
    fun filterProductList(
        productList: List<Product>,
        sortType: SortTypeEnum
    ): List<Product> {
        val map = mutableMapOf<String, Product>()
        return when (sortType) {
            SortTypeEnum.NAME -> {
                for (product in productList) {
                    map[product.name] = product
                }
                map.toSortedMap().values.reversed()
            }

            SortTypeEnum.BRAND -> {
                for (product in productList) {
                    map[product.brand] = product
                }
                map.toSortedMap().values.reversed()
            }
        }
    }
}