package com.sinyee.babybu.khghth

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sinyee.babybu.R
import com.sinyee.babybu.kjhgf.Wetsushcxis
import com.sinyee.babybu.werfgd.Jiosidjsuh
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.qoks
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.fijddfij
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.difjicjjixv
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.tiifj
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class Frsydudsh : AppCompatActivity() {

    lateinit var sidjdsji: String
    val coxkvokxvc: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var ijjicxizxic: String

    lateinit var sdok: String
    lateinit var xozkc: String
    lateinit var sdosdkasdks: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_froifdkfg)

        sdijsjid()
    }

    fun sdijsjid() {

        sdok = coxkvokxvc.getString(tiifj, null).toString()
        ijjicxizxic = coxkvokxvc.getString(Jiosidjsuh.rodkfko, null).toString()
        xozkc = coxkvokxvc.getString(difjicjjixv, null).toString()
        sdosdkasdks = coxkvokxvc.getString(qoks, null).toString()
        sidjdsji = coxkvokxvc.getString(fijddfij, null).toString()

        fkosjdsi()
    }

    fun fkosjdsi() {
        val dssidjisdj = Intent(this@Frsydudsh, Yuisodksd::class.java)

        if(xozkc=="1") {
            if(ijjicxizxic.contains("tdb2")&&sdok.contains("tdb2")) {
                dssidjisdj.putExtra("WebInt", "campaign")
                startActivity(dssidjisdj)
                finish()
            } else if (ijjicxizxic.contains("tdb2")|| sdosdkasdks.contains(sidjdsji)) {
                dssidjisdj.putExtra("WebInt", "campaign")
                startActivity(dssidjisdj)
                finish()
            } else if (sdok.contains("tdb2") && !ijjicxizxic.contains("tdb2")) {
                dssidjisdj.putExtra("WebInt", "deepLink")
                startActivity(dssidjisdj)
                finish()
            }
            else {
                startActivity(Intent(this, Wetsushcxis::class.java))
                finish()
            }
        } else {
            if (sdok.contains("tdb2")) {
                dssidjisdj.putExtra("WebInt", "deepLink")
                startActivity(dssidjisdj)
                finish()
            } else {
                    startActivity(Intent(this, Wetsushcxis::class.java))
                    finish()
                }
            }
        }


}