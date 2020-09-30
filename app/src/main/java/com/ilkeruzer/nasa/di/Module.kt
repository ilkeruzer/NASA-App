package com.ilkeruzer.nasa.di

import com.ilkeruzer.nasa.ui.fragment.curiosity.CuriosityViewModel
import com.ilkeruzer.nasa.ui.fragment.opportunity.OpportunityViewModel
import com.ilkeruzer.nasa.ui.fragment.spirit.SpiritViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

}

val networkModule = module {

}

val viewModelModule = module {
    viewModel { CuriosityViewModel() }
    viewModel { OpportunityViewModel() }
    viewModel { SpiritViewModel() }
}