import Versions.appcompat
import Versions.constraintLayout
import Versions.coreKtx
import Versions.coroutines
import Versions.daggerHilt
import Versions.espresso
import Versions.extJunit
import Versions.fragmentKtx
import Versions.material
import Versions.junit
import Versions.okHttp
import Versions.retrofit
import Versions.retrofitSerialization

object Versions {
    //app level
    const val gradle = "7.1.0-alpha01"
    const val kotlin = "1.5.0"

    //lib
    const val coreKtx = "1.5.0"
    const val appcompat = "1.3.0"
    const val material = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val fragmentKtx = "1.4.0-alpha03"
    //const val fragmentKtx = "1.2.0-alpha01"

    const val coroutines = "1.4.3"

    //dagger hilt
    const val daggerHilt = "2.38.1"

    //network
    const val okHttp = "4.8.1"
    const val retrofit = "2.9.0"
    const val retrofitSerialization = "0.6.0"

    //test
    const val junit = "4.+"
    const val extJunit = "1.1.2"
    const val espresso = "3.3.0"
}

object Dependencies {

    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:"
    const val ANDROIDX_CORE = "androidx.core:core-ktx:$coreKtx"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:$appcompat"
    const val ANDROIDX_MATERIAL = "com.google.android.material:material:$material"
    const val ANDROIDX_FRAGMENT = "androidx.fragment:fragment-ktx:$fragmentKtx"
    const val ANDROIDX_CONSTRAINT = "androidx.constraintlayout:constraintlayout:$constraintLayout"

    const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines"
    const val COROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"

    const val ANDROID_DAGGER_HILT = "com.google.dagger:hilt-android:$daggerHilt"
    const val ANDROID_DAGGER_HILT_COMPILER = "com.google.dagger:hilt-compiler:$daggerHilt"

    const val OKHTTP = "com.squareup.okhttp3:okhttp:$okHttp"
    const val OKHTTP_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:$okHttp"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:$retrofit"
    const val RETROFIT_SERIALIZATION = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofitSerialization"

    const val TEST_JUNIT = "junit:junit:$junit"
    const val TEST_EXT_JUNIT = "androidx.test.ext:junit:$extJunit"
    const val TEST_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:$espresso"
    const val TEST_TRUTH = "com.google.truth:truth:1.0.1"
}