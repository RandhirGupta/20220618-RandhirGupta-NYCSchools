package com.cyborg.nyc.feature_high_schools.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyborg.nyc.core.vo.Result
import com.cyborg.nyc.core.vo.Result.Loading
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchool
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchoolClusterItem
import com.cyborg.nyc.feature_high_schools.domain.usecase.GetHighSchoolsUseCase
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.algo.NonHierarchicalViewBasedAlgorithm
import kotlinx.coroutines.launch
import javax.inject.Inject


class HighSchoolsViewModel
@Inject constructor(
  private val getHighSchoolsUseCase: GetHighSchoolsUseCase,
) : ViewModel() {

  var highSchools = MutableLiveData<Result<List<HighSchool>>>()
    private set

  var highSchoolsClusterItem = MutableLiveData<NonHierarchicalViewBasedAlgorithm<HighSchoolClusterItem>>()
    private set

  fun getHighSchools() {
    highSchools.value = Loading
    viewModelScope.launch { highSchools.value = getHighSchoolsUseCase.invoke() }
  }

  fun updateHighSchoolClusterItem(highSchools: List<HighSchool>) {
    val algorithm = NonHierarchicalViewBasedAlgorithm<HighSchoolClusterItem>(0, 0)

    highSchools.map {
      val cluster = HighSchoolClusterItem(LatLng(it.lat, it.lng), it.schoolName)
      algorithm.addItem(cluster)
    }

    highSchoolsClusterItem.value = algorithm
  }
}
