package com.curso.android.app.proyectofinal

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.curso.android.app.proyectofinal.R
import com.curso.android.app.proyectofinal.R.*
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TextComparisonViewModel

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var resultTextView: TextView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        viewModel = ViewModelProvider(this).get(TextComparisonViewModel::class.java)

        editText1 = findViewById<AppCompatEditText>(id.editText1)
        editText2 = findViewById<AppCompatEditText>(id.editText2)
        resultTextView = findViewById(id.resultTextView)

        val btnComparar: AppCompatButton = findViewById<AppCompatButton>(id.btnComparar)

        btnComparar.setOnClickListener {
            viewModel.text1 = editText1.text.toString()
            viewModel.text2 = editText2.text.toString()

            if (viewModel.text1.isNotEmpty() && viewModel.text2.isNotEmpty()) {
                viewModel.compareTexts()

                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        }
        viewModel.comparisonResultLiveData.observe(this, { result ->
            resultTextView.text = result
        })

    }
}
