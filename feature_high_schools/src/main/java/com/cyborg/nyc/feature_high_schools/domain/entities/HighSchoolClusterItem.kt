package com.cyborg.nyc.feature_high_schools.domain.entities

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class HighSchoolClusterItem(private val position: LatLng, val name: String) : ClusterItem {

  override fun getPosition(): LatLng = position

  override fun getTitle(): String? = null

  override fun getSnippet(): String? = null
}
