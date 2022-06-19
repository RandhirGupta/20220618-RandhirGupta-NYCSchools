package com.cyborg.nyc.schools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {

  private val navController by lazy { Navigation.findNavController(this, R.id.navHostFragment) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    navController.navigateUp()
  }
}
