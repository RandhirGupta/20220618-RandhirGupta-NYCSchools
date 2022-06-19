package com.cyborg.nyc.feature_high_schools.domain.repository

import com.cyborg.nyc.core.vo.Result
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchool

interface HighSchoolsRepository {
  suspend fun getAllHighSchools(zip: String): Result<List<HighSchool>>
}
