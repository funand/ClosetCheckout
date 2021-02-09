package com.example.minicheckout

import com.example.minicheckout.core.utils.Filter
import com.example.minicheckout.core.utils.SortTypeEnum
import com.example.minicheckout.core.utils.getSampleProductList
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExampleUnitTest {

    @Test
    fun sortProductListByBrand_shouldReturnDescendingBrandSortedList() {
        // GIVEN
        var productList = getSampleProductList()
        Assert.assertEquals("25", productList[0].price)
        Assert.assertEquals("Adidas", productList[0].brand)
        Assert.assertEquals("16", productList[0].size)

        // WHEN
        productList = Filter.filterProductList(productList, SortTypeEnum.BRAND)

        // THEN
        Assert.assertEquals("2000", productList[0].price)
        Assert.assertEquals("Puma", productList[0].brand)
    }

    @Test
    fun sortProductListByName_shouldReturnDescendingNameSortedList() {
        // GIVEN
        var productList = getSampleProductList()
        Assert.assertEquals("25", productList[0].price)
        Assert.assertEquals("Adidas", productList[0].brand)

        // WHEN
        productList = Filter.filterProductList(productList, SortTypeEnum.NAME)

        // THEN
        Assert.assertEquals("Talon", productList[0].name)
        Assert.assertEquals("350", productList[0].price)
    }
}