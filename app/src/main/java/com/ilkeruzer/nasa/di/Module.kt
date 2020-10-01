package com.ilkeruzer.nasa.di

import com.ilkeruzer.nasa.data.repository.RoverRepository
import com.ilkeruzer.nasa.data.service.ApiService
import com.ilkeruzer.nasa.data.service.ApiServiceChief
import com.ilkeruzer.nasa.data.service.IApiService
import com.ilkeruzer.nasa.ui.adapter.RoverAdapter
import com.ilkeruzer.nasa.ui.fragment.curiosity.CuriosityViewModel
import com.ilkeruzer.nasa.ui.fragment.opportunity.OpportunityViewModel
import com.ilkeruzer.nasa.ui.fragment.spirit.SpiritViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { RoverAdapter(ArrayList(),false) }

    single { RoverRepository(get()) }
}

val networkModule = module {
    single { ApiService(ApiServiceChief.getRetrofit()!!.create(IApiService::class.java)) }
}

val viewModelModule = module {
    viewModel { CuriosityViewModel(get()) }
    viewModel { OpportunityViewModel(get()) }
    viewModel { SpiritViewModel(get()) }
}