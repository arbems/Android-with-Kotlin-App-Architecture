package com.arbems.mvvmbasic.utilities

import com.arbems.mvvmbasic.data.FakeDatabase
import com.arbems.mvvmbasic.data.QuoteRepository
import com.arbems.mvvmbasic.ui.quotes.QuotesViewModelFactory


object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}