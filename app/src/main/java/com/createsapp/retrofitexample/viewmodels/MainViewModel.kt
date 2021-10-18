package com.createsapp.retrofitexample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.createsapp.retrofitexample.model.QuoteList
import com.createsapp.retrofitexample.repository.QuoteRepository
import com.createsapp.retrofitexample.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: QuoteRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<Response<QuoteList>>
    get() = repository.quotes
}