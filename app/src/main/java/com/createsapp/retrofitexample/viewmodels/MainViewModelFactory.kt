package com.createsapp.retrofitexample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.createsapp.retrofitexample.repository.QuoteRepository

class MainViewModelFactory(private val repository: QuoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}