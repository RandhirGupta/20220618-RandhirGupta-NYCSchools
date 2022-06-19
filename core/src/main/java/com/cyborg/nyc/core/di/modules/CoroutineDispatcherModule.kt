package com.cyborg.nyc.core.di.modules

import com.cyborg.nyc.core.dispatcher.CoroutineDispatcherProvider
import com.cyborg.nyc.core.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module

@Module
interface CoroutineDispatcherModule {
  @Binds
  fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}
