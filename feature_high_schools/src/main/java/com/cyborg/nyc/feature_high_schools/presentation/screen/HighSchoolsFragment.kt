package com.cyborg.nyc.feature_high_schools.presentation.screen

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.AnimationUtils.loadAnimation
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.cyborg.nyc.core.NYCSchoolsApplication
import com.cyborg.nyc.core.vo.Result
import com.cyborg.nyc.core.vo.Result.*
import com.cyborg.nyc.feature_high_schools.R
import com.cyborg.nyc.feature_high_schools.databinding.FragmentHighSchoolsBinding
import com.cyborg.nyc.feature_high_schools.di.DaggerHighSchoolsComponent
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchool
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchoolClusterItem
import com.cyborg.nyc.feature_high_schools.presentation.adapter.HighSchoolsAdapter
import com.cyborg.nyc.feature_high_schools.presentation.viewmodel.HighSchoolsViewModel
import com.cyborg.presentation.BaseFragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.algo.NonHierarchicalViewBasedAlgorithm


class HighSchoolsFragment : BaseFragment<FragmentHighSchoolsBinding, HighSchoolsViewModel>(), OnMapReadyCallback {

  private val adapter by lazy { HighSchoolsAdapter() }
  private lateinit var clusterManager: ClusterManager<HighSchoolClusterItem>
  private var map: GoogleMap? = null
  private var toggle = true

  override fun getLayoutResourceId(): Int = R.layout.fragment_high_schools

  override fun initDaggerComponent() {
    DaggerHighSchoolsComponent
      .builder()
      .coreComponent(NYCSchoolsApplication.coreComponent(requireContext()))
      .build()
      .inject(this)
  }

  override fun getViewModelClass(): Class<HighSchoolsViewModel> = HighSchoolsViewModel::class.java

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.mapView.onCreate(savedInstanceState)
    initView()
    initHighSchoolsRecyclerView()
    registerGetHighSchoolsClusterItemObserver()
    registerGetHighSchoolsObserver()
    vm.getHighSchools()
  }

  override fun onResume() {
    super.onResume()

    binding.mapView.onResume()
  }

  override fun onPause() {
    super.onPause()

    binding.mapView.onPause()
  }

  override fun onDestroyView() {
    super.onDestroyView()

    binding.mapView.onDestroy()
  }

  private fun setUpMap(algorithm: NonHierarchicalViewBasedAlgorithm<HighSchoolClusterItem>) {
    if (map == null) return

    val metrics = DisplayMetrics()
    requireActivity().windowManager.defaultDisplay.getMetrics(metrics)

    val widthDp = (metrics.widthPixels / metrics.density).toInt()
    val heightDp = (metrics.heightPixels / metrics.density).toInt()

    algorithm.updateViewSize(widthDp, heightDp)

    clusterManager = ClusterManager(requireContext(), map)
    clusterManager.algorithm = algorithm
    map?.setOnCameraIdleListener { clusterManager }
  }

  private fun initView() {
    binding.mapView.getMapAsync(this)

    binding.btnRetry.setOnClickListener {
      vm.getHighSchools()
    }

    binding.tvToggle.setOnClickListener {
      if (toggle) {
        binding.rvHighSchools.visibility = View.VISIBLE
        binding.mapView.visibility = View.GONE
        toggle = false
      } else {
        binding.rvHighSchools.visibility = View.GONE
        binding.mapView.visibility = View.VISIBLE
        toggle = true
      }
    }
  }

  private fun initHighSchoolsRecyclerView() {
    val layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
    binding.rvHighSchools.layoutManager = layoutManager
    binding.rvHighSchools.adapter = adapter
  }

  private fun registerGetHighSchoolsClusterItemObserver() {
    vm.highSchoolsClusterItem.observe(viewLifecycleOwner) { setUpMap(it) }
  }

  private fun registerGetHighSchoolsObserver() {
    vm.highSchools.observe(viewLifecycleOwner) { subscribeGetHighSchools(it) }
  }

  private fun subscribeGetHighSchools(result: Result<List<HighSchool>>) {
    when (result) {
      is Loading -> handleGetHighSchoolsLoadingState()
      is Success -> handleGetHighSchoolsSuccessState(result.data)
      is Error -> handleGetHighSchoolsErrorState(result)
    }
  }

  private fun handleGetHighSchoolsLoadingState() {
    startRotatingImage()
    binding.loadingLayout.visibility = View.VISIBLE
    binding.errorLayout.visibility = View.GONE
    binding.layoutContent.visibility = View.GONE
  }

  private fun handleGetHighSchoolsSuccessState(highSchools: List<HighSchool>) {
    binding.loadingLayout.visibility = View.GONE
    binding.errorLayout.visibility = View.GONE
    binding.layoutContent.visibility = View.VISIBLE
    binding.rvHighSchools.visibility = View.VISIBLE
    binding.mapView.visibility = View.GONE

    adapter.setHighSchools(highSchools)
    vm.updateHighSchoolClusterItem(highSchools)
  }

  private fun handleGetHighSchoolsErrorState(error: Error) {
    binding.loadingLayout.visibility = View.GONE
    binding.errorLayout.visibility = View.VISIBLE
    binding.layoutContent.visibility = View.GONE
  }

  private fun startRotatingImage() {
    val startRotateAnimation = loadAnimation(requireContext(), R.anim.linear_interpolator)
    binding.ivLoader.startAnimation(startRotateAnimation)
  }

  override fun onMapReady(googleMap: GoogleMap) {
    if (map != null) return

    map = googleMap
  }
}
