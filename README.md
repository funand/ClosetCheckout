Tools added:

Picasso
Rxjava
Repository pattern
MVVM
Unit testing
Splash Screen
Suggestions:

Landscape view with master detail layout
Instrumentation test with espresso
Assumptions

Assumed to have real mock screen designs of what the layout should look like (preferably from UX/UI engineers) to increase user experience and retention
Assumed no caching was needed as this is an app that would always require network calls to get checkout items, and perform checkout functions
Returning to the checkout screen clears user's invoice




# Table of Contents
- Problem
- Requirements
- What's Included
- Evaluation Criteria

## Problem

After clients have received a shipment from Stitch Fix, they must decide which items to keep and which to return. They are only charged for items that they keep.

Our real-life app allows clients to make these selections. It also allows them to see an invoice view which displays the total price (including tax, discounts, credits, etc.) before finalizing these selections.

Your goal is to build an Android application that behaves like the checkout experience currently live in mobile. It should allow the client to make her keep/return selections, and to preview the total price of her selection.

## Requirements
On tapping the "Checkout" button, the user should be launched into the checkout flow.

The checkout flow should include a full screen view for each item, with the ability to navigate between items. For each item, the user should see:

* Name
* Brand
* Price
* Image
* A UI Control scheme for deciding whether to keep or return the item.


When the user is viewing the last item in their shipment, they should be able to navigate to an invoice/checkout view. The invoice view should:
* List the items that the user is keeping.
* Include the name, brand and price for each item.
* Clearly display the total price for the items that the user is keeping. (It does *not* need to include the subtotal or tax.)

## What's Included
### Starter Android Studio project
We've included a starter project to get you going. It is a single-screen app with 1 button. Tapping that "Checkout" button presents an alert "This feature is not yet implemented.". (This is where your work will come in!)

The starter project is written in Kotlin, and designed to run on latest version of Android Studio.

The starter project includes some of the design patterns and practices that we've used in our own Android app. Our hope is that this will give you a bit of an understanding about how we work. Feel free to refactor or extend anything as you see fit. Some of the patterns we've tried to illustrate include:
* Constraint Layout and Material Design
* Dependency Injection via Hilt / Dagger 2
* Componentized code design and organization
* Unit Test and UI Test
* Gradle Kotlin DSL scripts for dependencies 
  * Everything required to accomplish this task is included
  * Feel free to use any libraries or dependencies that you think are appropriate.
  * OPTIONAL : Feel free to uncomment areas to use newer alpha packages for things like Jetpack Compose if you feel more comfortable with that

The starter project includes some basic infrastructure to get you started, so you don't have to reinvent the wheel. It also demonstrates some facilities that we use in our Android app or are part of our roadmap. These include:
* Reactive streams via Kotlin Coroutines with Flow, SharedFlow, and StateFlow support
* Unit and UI Test libraries with some code for Espresso, JUnit, MockK, and Roboelectric (DI and Coroutine support too)
* Network libraries and code ready to go and implemented for your use (Retrofit + Moshi)
* Core DI classes implemented with methods ready to use (Hilt / Dagger2)
* Image Handling / Loading for local or network images (Glide)
* Lifecycle extensions and libraries (with extensions for all included libraries)
* ViewModel with DI and other extensions
* Nice to haves of things such as Themes, colors, fonts, animations, security (Allows Proxy use in `debug` builds), proguard files to enable you to just work but feel free to add more

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

## Evaluation criteria
We'll be evaluating your submission based on the following criteria:

*  Does it compile?
*  Is the code well-factored with appropriate abstractions?
*  Does it include appropriate automated tests or manual testing strategy (described in your README)?
*  Does it demonstrate an understanding of the requirements listed above?
*  Please email any questions to `mobiletakehome@stitchfix.com`. Don't be shy, send as many questions as you want!


We ask that you please include a README with your submission. In the README, you should include information that will help us evaluate your work:
* Any assumptions about UI/UX design, technical design, or product requirements. It's okay to make assumptions as long as you document them.
* If you have not provided automated tests, your manual testing strategy
* Given unlimited time, what would you do differently?

We're a company that thrives on data. We'd love if your README included some data about your experience working on this project. This information is optional and will *not* be used to evaluate your work. We'll use this data to improve the project for future candidates. We're specifically interested in:
* How long you spent on this project? (A rough estimate is fine. Nice to know how long to do the basic requirements as well as any additional time you spent on the project)
* What was the most challenging part of the project?
* Were there any aspects of this README that were unclear or confusing?
* Were there any aspects of the starter project that were unclear, confusing or buggy?

## Optional and Hints

Use of any of the provided components is completely optional. Feel free to do things your own way. We include a number of boilerplate things to help you move forward. You might also notice that there are multiple ways to access many of the helpers, which is intentional to accomodate the many accepted ways things can be done in Android.  
 ** Just because a component is provided does not mean you have to use it. **

Hints:
* Look at the libraries and classes closely for where to start or what to use, especially if "stuck"
* Read the comments on classes or functions for helpful hints 



*************************************************************************************
Tools added:
1. Picasso
2. Rxjava
3. Repository pattern
4. Single

Suggestions: 
1. Single activity app with navigation graph for multiple fragments
2. Landscape view with master detail layout
3. Instrumentation test with espresso


