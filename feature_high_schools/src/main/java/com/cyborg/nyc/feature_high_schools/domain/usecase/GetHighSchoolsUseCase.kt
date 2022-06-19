package com.cyborg.nyc.feature_high_schools.domain.usecase

import com.cyborg.nyc.core.vo.Result
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchool
import com.cyborg.nyc.feature_high_schools.domain.repository.HighSchoolsRepository
import javax.inject.Inject

class GetHighSchoolsUseCase
@Inject constructor(
  private val highSchoolsRepository: HighSchoolsRepository,
) {

  suspend operator fun invoke(): Result<List<HighSchool>> = highSchoolsRepository.getAllHighSchools("10002")
}
