package com.example.minicheckout

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.minicheckout.main.InvoiceActivity
import com.example.minicheckout.main.R
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<InvoiceActivity>
            = ActivityScenarioRule(InvoiceActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.minicheckout", appContext.packageName)
    }

    @Test
    fun testInitialLaunch() {
        onView(withId(R.id.invoice_title)).check(matches(isDisplayed()))
        onView(withId(R.id.invoice_back_btn)).check(matches(isDisplayed()))
        onView(withId(R.id.invoice_back_btn)).check(matches(isClickable()))
    }

    @Test
    fun testbackButtonClick_shouldLeaveInvoiceActivity_checkoutBackButtonIsPresent() {
        onView(withId(R.id.invoice_back_btn)).perform(click())
        onView(withId(R.id.checkoutButton))
    }
}