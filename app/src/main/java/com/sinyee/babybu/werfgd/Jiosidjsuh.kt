package com.sinyee.babybu.werfgd

import android.app.Application
import android.content.Context
import com.onesignal.OneSignal
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import java.util.*

class Jiosidjsuh: Application() {

    companion object {
        var kxcoxc: String? = "main_id"
        val qoks: String = "geoCo"
        var rodkfko: String? = "c11"

        const val icvjivc = "315e0ff7-8c54-4282-bf47-fe4f2a833bae"
        val kcxocxpc: String = "myID"
        val difjicjjixv: String = "appsCheckChe"

        val fijddfij: String = "uff"
        val tiifj: String = "deepL"
        var sdijsajidjia: String = "link"







    }

    override fun onCreate() {
        super.onCreate()
        val sydsudh = UUID.randomUUID().toString()
        val sidsdj = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val ixcjijxizxcjzsuh = getSharedPreferences("PREFS_NAME", 0)



        if (ixcjijxizxcjzsuh.getBoolean("my_first_time", true)) {
            sidsdj.edit().putString(kcxocxpc, sydsudh).apply()
            ixcjijxizxcjzsuh.edit().putBoolean("my_first_time", false).apply()
        }

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@Jiosidjsuh)
            modules(listOf(
                viewModelModule, appModule
            ))
        }

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(icvjivc)
    }
}