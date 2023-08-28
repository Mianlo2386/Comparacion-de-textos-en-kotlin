package com.curso.android.app.proyectofinal

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
     var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @org.junit.jupiter.api.BeforeEach
    fun setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    fun tearDown() {
    }
    @Test
    fun testMainActivityDisplayed() {

        onView(withId(R.id.editText1)).check(matches(isDisplayed()))


        onView(withId(R.id.editText2)).check(matches(isDisplayed()))


        onView(withId(R.id.btnComparar)).check(matches(isDisplayed()))


        onView(withId(R.id.resultTextView)).check(matches(isDisplayed()))
    }
}