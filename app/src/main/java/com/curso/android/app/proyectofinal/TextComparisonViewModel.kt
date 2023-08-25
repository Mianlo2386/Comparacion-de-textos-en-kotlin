package com.curso.android.app.proyectofinal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TextComparisonViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    private val _comparisonResultLiveData = MutableLiveData<String>()
    val comparisonResultLiveData: LiveData<String> get() = _comparisonResultLiveData

    var text1: String = ""
    var text2: String = ""
    var comparisonResult: String = ""

    fun compareTexts() {
        comparisonResult = if (text1 == text2) {
            context.getString(R.string.texts_are_equal)
        } else {
            context.getString(R.string.texts_are_not_equal)
        }
        _comparisonResultLiveData.value = comparisonResult
    }
}
