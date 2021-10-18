package com.createsapp.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.createsapp.retrofitexample.api.QuoteService
import com.createsapp.retrofitexample.api.RetrofitHelper
import com.createsapp.retrofitexample.repository.QuoteRepository
import com.createsapp.retrofitexample.repository.Response
import com.createsapp.retrofitexample.viewmodels.MainViewModel
import com.createsapp.retrofitexample.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            when(it){
                is Response.Loading ->{

                }

                is Response.Success -> {
                    it.data?.let {
                        Toast.makeText(this@MainActivity, it.results.size.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

                is Response.Error -> {
                    Toast.makeText(this@MainActivity, "Some Error Occured", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}