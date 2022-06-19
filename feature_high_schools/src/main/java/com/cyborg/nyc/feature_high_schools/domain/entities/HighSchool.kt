package com.cyborg.nyc.feature_high_schools.domain.entities

data class HighSchool(
  val dbn: String,
  val schoolName: String,
  val location: String,
  val lat: Double,
  val lng: Double,
)
