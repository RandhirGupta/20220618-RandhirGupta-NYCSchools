package com.cyborg.nyc.core.di.modules

import com.cyborg.nyc.core.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

  @Provides
  @Singleton
  fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
  }

  @Provides
  @Singleton
  fun provideAuthenticator(): Authenticator {
    return object : Authenticator {
      override fun authenticate(route: Route?, response: Response): Request? {
        return response
          .request
          .newBuilder()
          .header("X-App-Token", BuildConfig.APP_TOKEN)
          .build()
      }
    }
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor,
  ): OkHttpClient {
    val client = OkHttpClient.Builder()

    if (BuildConfig.DEBUG) client.addInterceptor(loggingInterceptor)

    return client.build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(MoshiConverterFactory.create())
      .client(okHttpClient)
      .build()
  }
}
