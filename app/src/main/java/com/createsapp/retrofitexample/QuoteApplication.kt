package com.createsapp.retrofitexample

import android.app.Application
import com.createsapp.retrofitexample.api.QuoteService
import com.createsapp.retrofitexample.api.RetrofitHelper
import com.createsapp.retrofitexample.db.QuoteDatabase
import com.createsapp.retrofitexample.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {
        val quotesService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quotesService, database,applicationContext)
    }
}