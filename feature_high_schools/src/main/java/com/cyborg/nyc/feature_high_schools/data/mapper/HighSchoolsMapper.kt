package com.cyborg.nyc.feature_high_schools.data.mapper

import com.cyborg.nyc.feature_high_schools.data.response.HighSchoolDto
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchool

class HighSchoolsMapper {

  fun map(highSchools: List<HighSchoolDto>): List<HighSchool> =
    highSchools.map { highSchoolDto ->
      HighSchool(
        dbn = highSchoolDto.dbn,
        schoolName = highSchoolDto.schoolName,
        location = highSchoolDto.location,
        lat = highSchoolDto.latitude.toDouble(),
        lng = highSchoolDto.longitude.toDouble()
      )
    }
}
