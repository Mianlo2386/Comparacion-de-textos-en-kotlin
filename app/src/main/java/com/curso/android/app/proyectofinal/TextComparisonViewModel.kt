package com.curso.android.app.proyectofinal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TextComparisonViewModel : ViewModel() {

    private val _comparisonResultLiveData = MutableLiveData<String>()
    val comparisonResultLiveData: LiveData<String> get() = _comparisonResultLiveData

    var text1: String = ""
    var text2: String = ""
    var comparisonResult: String = ""

    fun compareTexts() {
        comparisonResult = if (text1 == text2) {
            "Los textos son iguales"
        } else {
            "Los textos no son iguales"
        }
        _comparisonResultLiveData.value = comparisonResult
    }
}
