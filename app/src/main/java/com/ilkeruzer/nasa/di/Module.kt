package com.ilkeruzer.nasa.di

import com.ilkeruzer.nasa.data.ApiService
import com.ilkeruzer.nasa.data.ApiServiceChief
import com.ilkeruzer.nasa.data.IApiService
import com.ilkeruzer.nasa.ui.fragment.curiosity.CuriosityViewModel
import com.ilkeruzer.nasa.ui.fragment.opportunity.OpportunityViewModel
import com.ilkeruzer.nasa.ui.fragment.spirit.SpiritViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val networkModule = module {
    single { ApiService(ApiServiceChief.getRetrofit()!!.create(IApiService::class.java)) }
}

val viewModelModule = module {
    viewModel { CuriosityViewModel(get()) }
    viewModel { OpportunityViewModel() }
    viewModel { SpiritViewModel() }
}