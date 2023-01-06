package com.sinyee.babybu

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sinyee.babybu.khghth.Frsydudsh
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.difjicjjixv
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.rodkfko
import com.sinyee.babybu.werfgd.Jusyixcjzuch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    val usdhuhsad: SharedPreferences by inject(named("SharedPreferences"))

    val xchuzxc by viewModel<Jusyixcjzuch>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        xchuzxc.sdusdhu(this@MainActivity)

        xchuzxc.iqjjwijs(this@MainActivity)

        qowkd()

        GlobalScope.launch (Dispatchers.IO){
            xchuzxc.rioosdk()
        }

    }
    fun qowkd() {
        var xcijxcjiz = usdhuhsad.getString(difjicjjixv, null)
        var dokfsdij = usdhuhsad.getString(rodkfko, null)
        val ijasdjiixcjxiz = Executors.newSingleThreadScheduledExecutor()
        val susdhhsd = Executors.newSingleThreadScheduledExecutor()


        susdhhsd.scheduleAtFixedRate({
            if (xcijxcjiz != null) {
                Log.d("appsChec", "checkAppps:$xcijxcjiz ")
                susdhhsd.shutdownNow()
                when (xcijxcjiz) {
                    "1" ->
                        ijasdjiixcjxiz.scheduleAtFixedRate({
                            if (dokfsdij != null) {
                                ijasdjiixcjxiz.shutdownNow()
                                rokdkosa()
                            } else {
                                dokfsdij = usdhuhsad.getString(rodkfko, null)
                            }
                        }, 0, 1, TimeUnit.SECONDS)
                    else ->
                        rokdkosa()
                }
            } else {
                Log.d("appsChec", "checkAppps:$xcijxcjiz ")
                xcijxcjiz = usdhuhsad.getString(difjicjjixv, null)
            }
        }, 0, 1, TimeUnit.SECONDS)
    }


    fun rokdkosa() {
        val sduhhusd = Intent(this@MainActivity, Frsydudsh::class.java)
        startActivity(sduhhusd)
        finish()
    }


}