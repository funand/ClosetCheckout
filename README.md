## Tools included:
* Picasso
* Rxjava
* Repository pattern
* MVVM
* Unit testing
* Splash Screen
* Reactive streams via Kotlin Coroutines with Flow, SharedFlow, and StateFlow support
* Unit and UI Test libraries with some code for Espresso, JUnit, MockK, and Roboelectric (DI and Coroutine support too)
* Network libraries and code ready to go and implemented for your use (Retrofit + Moshi)
* Core DI classes implemented with methods ready to use (Hilt / Dagger2)
* Image Handling / Loading for local or network images (Glide)
* Lifecycle extensions and libraries (with extensions for all included libraries)
* ViewModel with DI and other extensions
* Nice to haves of things such as Themes, colors, fonts, animations, security (Allows Proxy use in `debug` builds), proguard files to enable you to just work but feel free to add more

## Assumptions:

Assumed to have real mock screen designs of what the layout should look like (preferably from UX/UI engineers) to increase user experience and retention
Assumed no caching was needed as this is an app that would always require network calls to get checkout items, and perform checkout functions
Returning to the checkout screen clears user's invoice

## Suggestions:
1. Single activity app with navigation graph for multiple fragments
2. Landscape view with master detail layout
3. Instrumentation test with espresso
4. Landscape view with master detail layout
5. Test HILT + Dagger map

## Problem

After clients have received a shipment, they must decide which items to keep and which to return. They are only charged for items that they keep.

Our real-life app allows clients to make these selections. It also allows them to see an invoice view which displays the total price (including tax, discounts, credits, etc.) before finalizing these selections.

Your goal is to build an Android application that behaves like the checkout experience currently live in mobile. It should allow the client to make her keep/return selections, and to preview the total price of her selection.

## Requirements
On tapping the "Checkout" button, the user should be launched into the checkout flow.

The checkout flow should display each item. For each item, the user should see:

* Name
* Brand
* Price
* Image
* A UI Control scheme for deciding whether to keep or return the item.

After selecting items, the user selected items should be displayed on the invoice view. The invoice view should:
* List the items that the user is keeping.
* Include the name, brand and price for each item.
* Clearly display the total price for the items that the user is keeping.

### Fake Backend
To get the list of items in a user's shipment, you'll need to make a call to:

`GET https://fake-mobile-backend.production.stitchfix.com/api/current_fix`.

This endpoint always returns JSON. It includes a `shipment_items` key, which contains an array of items in the user's current fix. Note that because this is a fake backend, it always returns the same data. The response looks like below.

```JSON
{
    "id": 5,
    "shipment_items": [
        {
            "id": 28008527,
            "name": "Dorothy Layered Hammered Cuff",
            "price": "34.0",
            "brand": "ZAD",
            "image_url": "https://fake-mobile-backend.production.stitchfix.com/image/hammered-cuff.jpg",
            "size": "medium"
        },
        ...
    ]
}
```













