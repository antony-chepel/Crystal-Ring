package com.sinyee.babybu.khghth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.sinyee.babybu.databinding.ActivityKsiduhwijsBinding
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.kcxocxpc
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.sdijsajidjia
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.tiifj
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.kxcoxc
import com.sinyee.babybu.werfgd.Jiosidjsuh.Companion.rodkfko
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class Yuisodksd : AppCompatActivity() {

    var xcijz: String? = null
    lateinit var sdijsdiisjd: WebView
    var sdosd = ""

    private val fodkidffd = 1
    var foddfokd = ""

    var oksdoksd: ValueCallback<Array<Uri>>? = null
    lateinit var kxzock: ActivityKsiduhwijsBinding
    private var rijsdok = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kxzock = ActivityKsiduhwijsBinding.inflate(layoutInflater)
        setContentView(kxzock.root)

        sdijsdiisjd = kxzock.reysudsai
        Snackbar.make(
            kxzock.root, "Loading...",
            Snackbar.LENGTH_SHORT
        ).show()


        val odfgkf = CookieManager.getInstance()
        odfgkf.setAcceptCookie(true)
        odfgkf.setAcceptThirdPartyCookies(sdijsdiisjd, true)
        roekfko()
        val dsisd: Activity = this
        sdijsdiisjd.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(gfsdkko: WebView, sdjiad: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(sdjiad)) {
                        return false
                    }
                    if (eoskd(sdjiad)) {

                        val gkofof = Intent(Intent.ACTION_VIEW)
                        gkofof.data = Uri.parse(sdjiad)
                        startActivity(gkofof)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }

            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

                dfosdfk(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(dsisd, description, Toast.LENGTH_SHORT).show()
            }


        }
        sdijsdiisjd.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                sdija: WebView, zxicjz: ValueCallback<Array<Uri>>,
                oskoasokdas: FileChooserParams
            ): Boolean {
                oksdoksd?.onReceiveValue(null)
                oksdoksd = zxicjz
                var tijijds: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (tijijds!!.resolveActivity(packageManager) != null) {
                    var sdakoasdkoasd: File? = null
                    try {
                        sdakoasdkoasd = sdjids()
                        tijijds.putExtra("PhotoPath", xcijz)
                    } catch (ex: IOException) {

                    }


                    if (sdakoasdkoasd != null) {
                        xcijz = "file:" + sdakoasdkoasd.absolutePath
                        tijijds.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(sdakoasdkoasd)
                        )
                    } else {
                        tijijds = null
                    }
                }
                val vockvb = Intent(Intent.ACTION_GET_CONTENT)
                vockvb.addCategory(Intent.CATEGORY_OPENABLE)
                vockvb.type = "image/*"
                val fodkfkodgo: Array<Intent?> =
                    tijijds?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val nijbijv = Intent(Intent.ACTION_CHOOSER)
                nijbijv.putExtra(Intent.EXTRA_INTENT, vockvb)
                nijbijv.putExtra(Intent.EXTRA_TITLE, "Pick your image")
                nijbijv.putExtra(Intent.EXTRA_INITIAL_INTENTS, fodkfkodgo)
                startActivityForResult(
                    nijbijv, fodkidffd
                )
                return true
            }

            @Throws(IOException::class)
            private fun sdjids(): File {
                var okxccjxijzxc = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!okxccjxijzxc.exists()) {
                    okxccjxijzxc.mkdirs()
                }

                okxccjxijzxc =
                    File(okxccjxijzxc.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return okxccjxijzxc
            }

        }

        sdijsdiisjd.loadUrl(rookdfkos())
    }

    private fun fidgijf(xock: String) {
        OneSignal.setExternalUserId(
            xock,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(eoidsods: JSONObject) {
                    try {
                        if (eoidsods.has("push") && eoidsods.getJSONObject("push").has("success")) {
                            val fdfokdf = eoidsods.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $fdfokdf"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (eoidsods.has("email") && eoidsods.getJSONObject("email").has("success")) {
                            val aosksoka =
                                eoidsods.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $aosksoka"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (eoidsods.has("sms") && eoidsods.getJSONObject("sms").has("success")) {
                            val ovbkkocv = eoidsods.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $ovbkkocv"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }
    private fun roekfko() {
        val dasko = sdijsdiisjd.settings
        dasko.setAppCacheEnabled(true)
        dasko.builtInZoomControls = true
        dasko.setSupportZoom(true)
        dasko.pluginState = WebSettings.PluginState.ON
        dasko.loadWithOverviewMode = true
        dasko.allowFileAccess = true

        dasko.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        dasko.javaScriptEnabled = true
        dasko.javaScriptCanOpenWindowsAutomatically = true
        dasko.allowContentAccess = true
        dasko.setSupportMultipleWindows(false)
        dasko.displayZoomControls = false
        dasko.useWideViewPort = true

        dasko.domStorageEnabled = true
        dasko.userAgentString = dasko.userAgentString.replace("; wv", "")




    }




    override fun onActivityResult(suishd: Int, sdaiasdj: Int, ivjidfj: Intent?) {
        if (suishd != fodkidffd || oksdoksd == null) {
            super.onActivityResult(suishd, sdaiasdj, ivjidfj)
            return
        }
        var dsijasdiasdj: Array<Uri>? = null

        if (sdaiasdj == AppCompatActivity.RESULT_OK) {
            if (ivjidfj == null || ivjidfj.data == null) {

                dsijasdiasdj = arrayOf(Uri.parse(xcijz))
            } else {
                val qokdkos = ivjidfj.dataString
                if (qokdkos != null) {
                    dsijasdiasdj = arrayOf(Uri.parse(qokdkos))
                }
            }
        }
        oksdoksd?.onReceiveValue(dsijasdiasdj)
        oksdoksd = null
    }
    private fun rookdfkos(): String {

        val okkodsijasd = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)

        val xcijxcz = "com.sinyee.babybu"
        val cozkxjcii = Build.VERSION.RELEASE
        val sdij = "deviceID="
        val sdijsd: String? = okkodsijasd.getString(sdijsajidjia, null)
        val osdkaokiasjasd = "sub_id_6="
        val sodk = intent


        val sudhhusd = sodk.getStringExtra("WebInt")
        val xicj: String? = okkodsijasd.getString(kxcoxc, "null")
        val qokd = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        val xcijxi = "naming"
        val ixcjjizxjizxcji = "deeporg"

        AppsFlyerLib.getInstance().setCollectAndroidID(true)
        val xuchzuhc = "sub_id_4="
        val qoksd = "sub_id_5="

        val fokdfko = okkodsijasd.getString(kcxocxpc, null)
        val woksd: String? = okkodsijasd.getString(rodkfko, null)
        val sdok = "sub_id_1="
        val sdplsalpasdxockzxc = "ad_id="
        val osdkaosddisj: String? = okkodsijasd.getString(tiifj, null)

        when (sudhhusd) {
            "deepLink" -> {
                sdosd ="$sdijsd$sdok$osdkaosddisj&$sdij$qokd&$sdplsalpasdxockzxc$xicj&$xuchzuhc$xcijxcz&$qoksd$cozkxjcii&$osdkaokiasjasd$ixcjjizxjizxcji"
                fidgijf(fokdfko.toString())
                Log.d("TESTAG", "urururururururur deep: $sdosd")
            }
            "campaign" -> {
                sdosd =
                    "$sdijsd$sdok$woksd&$sdij$qokd&$sdplsalpasdxockzxc$xicj&$xuchzuhc$xcijxcz&$qoksd$cozkxjcii&$osdkaokiasjasd$xcijxi"
                fidgijf(qokd.toString())
                Log.d("TESTAG", "urururururururur apps: $sdosd")
            }
        }
        return okkodsijasd.getString("SAVED_URL", sdosd).toString()
    }





    private fun eoskd(xczok: String): Boolean {

        val xijasidjjiasd = packageManager
        try {
            xijasidjjiasd.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }




    override fun onBackPressed() {
            if (sdijsdiisjd.canGoBack()) {
                if (rijsdok) {
                    sdijsdiisjd.stopLoading()
                    sdijsdiisjd.loadUrl(foddfokd)
                }
                this.rijsdok = true
                sdijsdiisjd.goBack()
                Handler(Looper.getMainLooper()).postDelayed(Runnable {
                    rijsdok = false
                }, 2000)

            } else {
                super.onBackPressed()
            }
    }


    fun dfosdfk(sdlpsd: String?) {
        if (!sdlpsd!!.contains("t.me")) {

            if (foddfokd == "") {
                foddfokd = getSharedPreferences(
                    "SHARED_PREF",
                    MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    sdlpsd
                ).toString()

                val xcizxcj = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
                val dosksd = xcizxcj.edit()
                dosksd.putString("SAVED_URL", sdlpsd)
                dosksd.apply()
            }
        }
    }

}

