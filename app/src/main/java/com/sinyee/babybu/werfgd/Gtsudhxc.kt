package com.sinyee.babybu.werfgd

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sinyee.babybu.khghth.Hysisjioskdmkxmcxkm
import com.sinyee.babybu.khghth.Ijisosdkkosdkosd
import com.sinyee.babybu.khghth.Qwsodksd
import com.sinyee.babybu.khghth.Vfxuhchuxijs
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single  <Vfxuhchuxijs> (named("HostInter")){
        get<Retrofit>(named("RetroDev"))
            .create(Vfxuhchuxijs::class.java)
    }

    single <Qwsodksd> (named("ApiInter")) {
        get<Retrofit>(named("RetroCountry"))
            .create(Qwsodksd::class.java)
    }
    single<Retrofit>(named("RetroCountry")) {
        Retrofit.Builder()
            .baseUrl("http://pro.ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }
    single <Retrofit>(named("RetroDev")){
        Retrofit.Builder()
            .baseUrl("http://crystalring.live/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory (named("CountryRep")) {
        Ijisosdkkosdkosd(get(named("ApiInter")))
    }

    factory  (named("DevRep")){
        Hysisjioskdmkxmcxkm(get(named("HostInter")))
    }
    single{
        sdijjsdi()
    }
    single (named("SharedPreferences")) {
        iosdkasdkasd(androidApplication())
    }

}

val viewModelModule = module {
    viewModel {
        Jusyixcjzuch(get(named("CountryRep")), get(named("DevRep")), get(named("SharedPreferences")), get())
    }
}

fun sdijjsdi(): Gson {
    return GsonBuilder().create()
}

fun iosdkasdkasd(app: Application): SharedPreferences {
    return app.applicationContext.getSharedPreferences(
        "SHARED_PREF",
        Context.MODE_PRIVATE
    )
}