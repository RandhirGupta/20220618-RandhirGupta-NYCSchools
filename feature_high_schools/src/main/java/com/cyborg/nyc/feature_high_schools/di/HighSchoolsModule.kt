package com.cyborg.nyc.feature_high_schools.di

import com.cyborg.nyc.core.di.scope.FeatureScope
import com.cyborg.nyc.feature_high_schools.data.HighSchoolsService
import com.cyborg.nyc.feature_high_schools.data.mapper.HighSchoolsMapper
import com.cyborg.nyc.feature_high_schools.data.source.HighSchoolsRemoteDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HighSchoolsModule {

  @Provides
  @FeatureScope
  fun provideHighSchoolsMapper(): HighSchoolsMapper = HighSchoolsMapper()

  @Provides
  @FeatureScope
  fun provideHighSchoolsService(retrofit: Retrofit): HighSchoolsService = retrofit.create(HighSchoolsService::class.java)

  @Provides
  @FeatureScope
  fun provideRemoteDataSource(highSchoolsService: HighSchoolsService): HighSchoolsRemoteDataSource = HighSchoolsRemoteDataSource(highSchoolsService)
}
