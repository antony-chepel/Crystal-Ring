package com.sinyee.babybu.kjhgf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import com.sinyee.babybu.R
import com.sinyee.babybu.databinding.ActivityWetsushcxisBinding
import kotlin.random.Random

class Wetsushcxis : AppCompatActivity() {
    private var dijsasjid: CountDownTimer? = null
    private lateinit var diofokdfs : ActivityWetsushcxisBinding
    private var oxczkzckox = false
    val eiisdj = listOf(
        "Sweetness : x2",
        "Sweetness : x5",
        "Sweetness : x16",
        "Sweetness : x20",
        "Sweetness : x25",
        "Sweetness : x30",
        "Sweetness : x45",
        "Sweetness : x55",
        "Sweetness : x64",
        "Sweetness : x80",
        "Sweetness : x100",

        )
    val eirjisdji = listOf(
        R.drawable.cring_1,
        R.drawable.cring_2,
        R.drawable.cring_3,
        R.drawable.cring_4,
        R.drawable.cring_5,
    )


    val oxzcpcxlzzxc = listOf(
        "Freshness: x5",
        "Freshness: x8",
        "Freshness: x15",
        "Freshness: x23",
        "Freshness: x40",
        "Freshness: x60",
        "Freshness: x80",
        "Freshness: x100",
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diofokdfs = ActivityWetsushcxisBinding.inflate(layoutInflater)
        setContentView(diofokdfs.root)

        if(oxczkzckox == false) {
            diofokdfs.xock.setOnClickListener {
                oyijiifg()

            }
        }
    }

    private fun oyijiifg() = with(diofokdfs){
        var odkdfo = 0
        dijsasjid?.cancel()
        dijsasjid = object : CountDownTimer(3000,100){
            override fun onTick(millisUntilFinished: Long) {
                odkdfo++
                oxczkzckox = true
                xock.alpha = 0.7f
                if(odkdfo>4)odkdfo = 0
                xopckoxc.text = oxzcpcxlzzxc[odkdfo]
                xzokckzxo.text = eiisdj[odkdfo]
                xijcxji.setImageResource(eirjisdji[odkdfo])
                aspsdoksdk.setImageResource(eirjisdji[odkdfo])

            }

            override fun onFinish() {
                vobcvjiuhfsd()
                oxczkzckox = false
                xock.alpha = 1.0f

            }

        }.start()

    }

    private fun vobcvjiuhfsd() =with(diofokdfs) {
        val eioreji = eiisdj[Random.nextInt(11)]
        val ovkb= oxzcpcxlzzxc[Random.nextInt(8)]
        val fokdokdj= eirjisdji[Random.nextInt(5)]
        val doesjidsd= eirjisdji[Random.nextInt(5)]

        xopckoxc.text = eioreji
        xzokckzxo.text = ovkb
        xijcxji.setImageResource(fokdokdj)
        aspsdoksdk.setImageResource(doesjidsd)

        Handler().postDelayed({
            startActivity(
                Intent(this@Wetsushcxis, Sysisajduxcz::class.java)
            )
        },1000)


    }


}