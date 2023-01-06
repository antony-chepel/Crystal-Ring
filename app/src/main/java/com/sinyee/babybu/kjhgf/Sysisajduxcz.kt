package com.sinyee.babybu.kjhgf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sinyee.babybu.databinding.ActivitySysisajduxczBinding
import kotlin.random.Random

class Sysisajduxcz : AppCompatActivity() {
    private lateinit var njxcjxixc : ActivitySysisajduxczBinding
    val listres = listOf(
        "You got 10 pound of sweet fruits",
        "You got 20 pound of sweet fruits",
        "You got 40 pound of sweet fruits",
        "You got 60 pound of sweet fruits",
        "You got 100 pound of sweet fruits",
        "You got 200 pound of sweet fruits",
        "You got 500 pound of sweet fruits",
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        njxcjxixc = ActivitySysisajduxczBinding.inflate(layoutInflater)
        setContentView(njxcjxixc.root)
        njxcjxixc.sidjjis.text = listres[Random.nextInt(7)]
        njxcjxixc.xzijc.setOnClickListener {
            startActivity(Intent(this,Wetsushcxis::class.java))
        }
    }
}