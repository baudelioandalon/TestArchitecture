import java.text.SimpleDateFormat
import java.util.*

object AndroidConfig {
    const val minSdk = 24
    const val targetSdk = 32
    const val compileSdk = 32
    const val appId = "com.boreal.testarchitecture"
    const val versionCode = 1
    val versionName = "1.0.0-${SimpleDateFormat("yyyyMMdd", Locale.US).format(Date())}"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}