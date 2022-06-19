package com.cyborg.nyc.core

import android.app.Application
import android.content.Context
import com.cyborg.nyc.core.di.CoreComponent
import com.cyborg.nyc.core.di.DaggerCoreComponent

class NYCSchoolsApplication : Application() {

  lateinit var coreComponent: CoreComponent

  companion object {

    @JvmStatic
    fun coreComponent(context: Context): CoreComponent? = (context.applicationContext as? NYCSchoolsApplication)?.coreComponent
  }

  override fun onCreate() {
    super.onCreate()

    initCoreDependencyInjection()
  }

  private fun initCoreDependencyInjection() {
    coreComponent = DaggerCoreComponent
      .builder()
      .application(this)
      .build()
  }
}
