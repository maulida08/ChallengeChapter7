package com.ida.challengechapter7.di

import com.ida.challengechapter7.ui.home.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeFragmentViewModel)
}