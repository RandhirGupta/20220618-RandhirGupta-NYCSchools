package com.cyborg.nyc.feature_high_schools.di

import com.cyborg.nyc.feature_high_schools.data.HighSchoolsRepositoryImpl
import com.cyborg.nyc.feature_high_schools.domain.repository.HighSchoolsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

  @Binds
  fun bindHighSchoolsRepository(repository: HighSchoolsRepositoryImpl): HighSchoolsRepository
}
