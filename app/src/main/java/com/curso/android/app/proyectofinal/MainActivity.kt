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

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var resultTextView: TextView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        editText1 = findViewById<AppCompatEditText>(id.editText1)
        editText2 = findViewById<AppCompatEditText>(id.editText2)
        resultTextView = findViewById(id.resultTextView)

        val btnComparar: AppCompatButton = findViewById<AppCompatButton>(id.btnComparar)

        btnComparar.setOnClickListener {
            val text1: String = editText1.text.toString()
            val text2: String = editText2.text.toString()

            if (text1.isNotEmpty() || text2.isNotEmpty()) {
                if (text1 == text2) {
                    resultTextView.text = getString(string.texts_are_equal)
                } else {
                    resultTextView.text = getString(string.texts_are_not_equal)
                }
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        }
    }
}
