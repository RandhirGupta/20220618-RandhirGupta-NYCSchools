package com.cyborg.nyc.feature_high_schools.data

import com.cyborg.nyc.feature_high_schools.data.response.HighSchoolDto
import retrofit2.http.GET
import retrofit2.http.Query

interface HighSchoolsService {

  @GET("/resource/s3k6-pzi2.json")
  suspend fun getHighSchools(
    @Query("zip") zip: String,
  ): List<HighSchoolDto>
}
