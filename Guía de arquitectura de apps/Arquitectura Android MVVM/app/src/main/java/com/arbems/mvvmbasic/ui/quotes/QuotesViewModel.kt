package com.arbems.mvvmbasic.ui.quotes

import androidx.lifecycle.ViewModel
import com.arbems.mvvmbasic.data.Quote
import com.arbems.mvvmbasic.data.QuoteRepository


class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}