package com.cyborg.nyc.core.di

import android.app.Application
import android.content.Context
import com.cyborg.nyc.core.di.modules.ContextModule
import com.cyborg.nyc.core.di.modules.CoroutineDispatcherModule
import com.cyborg.nyc.core.di.modules.NetworkModule
import com.cyborg.nyc.core.dispatcher.DispatcherProvider
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    ContextModule::class,
    NetworkModule::class,
    CoroutineDispatcherModule::class
  ]
)
interface CoreComponent {
  fun context(): Context
  fun retrofit(): Retrofit
  fun dispatcher(): DispatcherProvider

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): CoreComponent
  }
}
