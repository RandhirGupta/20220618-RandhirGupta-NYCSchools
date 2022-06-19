object Libs {

  const val kotlinVersion = "1.6.21"

  object Android {
    const val retrofitVersion = "2.9.0"
    const val daggerVersion = "2.24"
    const val lifecycleVersion = "2.1.0"

    const val navigationVersion = "2.2.0-rc04"

    object Main {
      const val kotlinJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
      const val kotlinCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3-native-mt"
      const val ktxAndroid = "androidx.core:core-ktx:1.8.0"
      const val appCompat = "androidx.appcompat:appcompat:1.4.2"
      const val materialAndroid = "com.google.android.material:material:1.6.1"
      const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
      const val cardView = "androidx.cardview:cardview:1.0.0"
      const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0-alpha01"
      const val navigationFragment = "androidx.navigation:navigation-fragment:$navigationVersion"
      const val navigation = "androidx.navigation:navigation-ui:$navigationVersion"
      const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
      const val navigationKtx = "androidx.navigation:navigation-ui-ktx:$navigationVersion"

      const val lifecycleVersionExtension = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
      const val lifeCycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"
      const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"

      const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
      const val moshi = "com.squareup.moshi:moshi:1.8.0"
      const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
      const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.2.2"

      const val mapsKtx = "com.google.maps.android:maps-ktx:3.4.0"
      const val mapsUtilsKtx = "com.google.maps.android:maps-utils-ktx:3.4.0"
      const val playServiceMaps = "com.google.android.gms:play-services-maps:18.0.2"
      const val mapsUtils = "com.google.maps.android:android-maps-utils:2.3.0"

      const val dagger = "com.google.dagger:dagger:$daggerVersion"
      const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    }

    object Test {
      const val jUnit = "junit:junit:4.13.2"
      const val androidXJunit = "androidx.test.ext:junit:1.1.3"
      const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }
  }

  object Modules {
    const val core = ":core"
    const val presentation = ":presentation"
    const val featureHighSchools = ":feature_high_schools"
  }
}
