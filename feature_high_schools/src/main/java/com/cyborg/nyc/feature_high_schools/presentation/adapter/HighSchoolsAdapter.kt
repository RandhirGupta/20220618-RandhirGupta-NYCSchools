package com.cyborg.nyc.feature_high_schools.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cyborg.nyc.feature_high_schools.databinding.ItemHighSchoolBinding
import com.cyborg.nyc.feature_high_schools.domain.entities.HighSchool

class HighSchoolsAdapter : RecyclerView.Adapter<HighSchoolsAdapter.HighSchoolViewHolder>() {

  private val highSchools = mutableListOf<HighSchool>()

  @SuppressLint("NotifyDataSetChanged")
  fun setHighSchools(highSchools: List<HighSchool>) {
    if (!highSchools.isNullOrEmpty()) {
      this.highSchools.clear()
      this.highSchools.addAll(highSchools)
      notifyDataSetChanged()
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighSchoolViewHolder =
    HighSchoolViewHolder.create(parent)

  override fun onBindViewHolder(holder: HighSchoolViewHolder, position: Int) {
    holder.bind(highSchools[position])
  }

  override fun getItemCount(): Int = highSchools.size

  class HighSchoolViewHolder(private val binding: ItemHighSchoolBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
      fun create(parent: ViewGroup): HighSchoolViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHighSchoolBinding.inflate(layoutInflater, parent, false)
        return HighSchoolViewHolder(binding)
      }
    }

    fun bind(highSchool: HighSchool) {
      binding.highSchool = highSchool
    }
  }
}
