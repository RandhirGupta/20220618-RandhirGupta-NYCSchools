package com.cyborg.nyc.feature_high_schools.di

import com.cyborg.nyc.core.di.CoreComponent
import com.cyborg.nyc.core.di.scope.FeatureScope
import com.cyborg.nyc.feature_high_schools.presentation.screen.HighSchoolsFragment
import dagger.Component

@FeatureScope
@Component(
  dependencies = [CoreComponent::class],
  modules = [
    RepositoryModule::class,
    HighSchoolsModule::class,
    ViewModelModule::class
  ]
)
interface HighSchoolsComponent {
  fun inject(highSchoolsFragment: HighSchoolsFragment)
}
