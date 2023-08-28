package com.curso.android.app.proyectofinal


import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class TextComparisonViewModelTest {

    private lateinit var viewModel: TextComparisonViewModel

     @get:Rule
     val instantTaskRule = InstantTaskExecutorRule()
     private val dispatcher = StandardTestDispatcher()
    private lateinit var context: Context

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = TextComparisonViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun testEqualTexts() {
        viewModel.text1 = "Hola Gente Linda!"
        viewModel.text2 = "Hola Gente Linda!"
        viewModel.compareTexts()
        assertEquals("Los textos son iguales", viewModel.comparisonResult)
    }

    @Test
    fun testNotEqualTexts() {
        viewModel.text1 = "Hola gente fea!"
        viewModel.text2 = "Holaaaaaa"
        viewModel.compareTexts()
        assertEquals("Los textos no son iguales", viewModel.comparisonResult)
    }
}
