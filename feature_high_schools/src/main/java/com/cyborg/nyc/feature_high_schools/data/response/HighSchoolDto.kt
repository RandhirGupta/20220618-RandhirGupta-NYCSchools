package com.cyborg.nyc.feature_high_schools.data.response

import com.squareup.moshi.Json

data class HighSchoolDto(
  @field:Json(name = "dbn")
  val dbn: String,

  @field:Json(name = "school_name")
  val schoolName: String,

  @field:Json(name = "latitude")
  val latitude: String,

  @field:Json(name = "longitude")
  val longitude: String,

  @field:Json(name = "location")
  val location: String,

  @field:Json(name = "zip")
  val zip: String,
)
