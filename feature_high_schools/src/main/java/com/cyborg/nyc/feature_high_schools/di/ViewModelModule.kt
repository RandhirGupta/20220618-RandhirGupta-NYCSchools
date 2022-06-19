package com.cyborg.nyc.feature_high_schools.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cyborg.nyc.core.di.ViewModelFactory
import com.cyborg.nyc.core.di.ViewModelKey
import com.cyborg.nyc.feature_high_schools.presentation.viewmodel.HighSchoolsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(HighSchoolsViewModel::class)
  abstract fun providesHomeViewModel(viewModel: HighSchoolsViewModel): ViewModel
}
