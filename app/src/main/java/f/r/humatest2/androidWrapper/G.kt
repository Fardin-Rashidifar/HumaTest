package f.r.f.hamrahanandroidkotlin.androidWrapper

import android.Manifest
import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import dagger.hilt.android.HiltAndroidApp
import f.r.f.hamrahanandroidkotlin.BuildConfig
import f.r.f.hamrahanandroidkotlin.R
import f.r.f.hamrahanandroidkotlin.Utils
import f.r.f.hamrahanandroidkotlin.helper.SendingLocationToServerService
import ir.atitec.everythingmanager.manager.FontManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltAndroidApp
class G : Application() {
    companion object {
        lateinit var instance: G
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        //  FontManager.init(this,R.string.myFont);
        FontManager.init(this, R.string.defaultFontName)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }



    }



}