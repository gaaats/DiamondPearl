package com.trophymanager.pro

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import com.trophymanager.pro.CompanionClasss.Companion.froofrfo
import com.trophymanager.pro.CompanionClasss.Companion.MAIN_IDfrrrr
import com.trophymanager.pro.CompanionClasss.Companion.linkfrrr
import com.trophymanager.pro.databinding.ActivityVebSearchBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class VebSearchActivity : AppCompatActivity() {
    private val ftgtgtt = 1
    var kgjfhdkxf: String? = null
    var frgtgttgt: ValueCallback<Array<Uri>>? = null

    lateinit var mmo: WebView
    lateinit var hly: ActivityVebSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hly = ActivityVebSearchBinding.inflate(layoutInflater)
        setContentView(hly.root)

        mmo = hly.veveveveev
        Snackbar.make(
            hly.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val hyhy = CookieManager.getInstance()
        hyhy.setAcceptCookie(true)
        hyhy.setAcceptThirdPartyCookies(mmo, true)
        kikiik()
        val gtgtgt: Activity = this
        mmo.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (oyoyoyoy(url)) {

                        val yhyhy = Intent(Intent.ACTION_VIEW)
                        yhyhy.data = Uri.parse(url)
                        startActivity(yhyhy)
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
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                //Save the last visited URL
                saveUrl(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(gtgtgt, description, Toast.LENGTH_SHORT).show()
            }


        }
        mmo.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                frgtgttgt?.onReceiveValue(null)
                frgtgttgt = filePathCallback
                var ggttgtt: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (ggttgtt!!.resolveActivity(packageManager) != null) {

                    var photoFile: File? = null
                    try {
                        photoFile = gtgtgttg()
                        ggttgtt.putExtra("PhotoPath", kgjfhdkxf)
                    } catch (ex: IOException) {
                    }

                    if (photoFile != null) {
                        kgjfhdkxf = "file:" + photoFile.absolutePath
                        ggttgtt.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile)
                        )
                    } else {
                        ggttgtt = null
                    }
                }
                val frffr = Intent(Intent.ACTION_GET_CONTENT)
                frffr.addCategory(Intent.CATEGORY_OPENABLE)
                frffr.type = "image/*"
                val gthyhyh: Array<Intent?> =
                    ggttgtt?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val cfccfcf = Intent(Intent.ACTION_CHOOSER)
                cfccfcf.putExtra(Intent.EXTRA_INTENT, frffr)
                cfccfcf.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                cfccfcf.putExtra(Intent.EXTRA_INITIAL_INTENTS, gthyhyh)
                startActivityForResult(
                    cfccfcf, ftgtgtt
                )
                return true
            }

            @Throws(IOException::class)
            private fun gtgtgttg(): File {
                var nonoon = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!nonoon.exists()) {
                    nonoon.mkdirs()
                }

                nonoon =
                    File(nonoon.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return nonoon
            }

        }

        mmo.loadUrl(gtggtt())
    }


    private fun frffrrr(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val gtgtl = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $gtgtl"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val gtgttgt =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $gtgttgt"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val frrrrrrr = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $frrrrrrr"
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

    private fun kikiik() {
        val bnbnb = mmo.settings
        bnbnb.javaScriptEnabled = true

        bnbnb.useWideViewPort = true

        bnbnb.loadWithOverviewMode = true
        bnbnb.allowFileAccess = true
        bnbnb.domStorageEnabled = true
        bnbnb.userAgentString = bnbnb.userAgentString.replace("; wv", "")

        bnbnb.javaScriptCanOpenWindowsAutomatically = true
        bnbnb.setSupportMultipleWindows(false)

        bnbnb.displayZoomControls = false
        bnbnb.builtInZoomControls = true
        bnbnb.setSupportZoom(true)

        bnbnb.pluginState = WebSettings.PluginState.ON
        bnbnb.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        bnbnb.setAppCacheEnabled(true)

        bnbnb.allowContentAccess = true
    }

    private fun gtggtt(): String {

        val jujuu = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val popopo = "com.trophymanager.pro"

        val myTrIDfrgtt: String? = Hawk.get(CompanionClasss.frfrrfr, "null")
        val myInstIdfgtgt: String? = Hawk.get(CompanionClasss.frrfrr, "null")
        val cpOnegtgtgt:String? = Hawk.get(froofrfo)
        val mainIdfrgtt: String? = Hawk.get(MAIN_IDfrrrr, "null")

        val checkFlyfrggt: String = Hawk.get(CompanionClasss.apapap)

        val afIdddddd = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)



        val onefgttg = "deviceID="
        val subOnefrfr = "sub_id_1="
        val thrhtrhtrhtrhtfrfr = "ad_id="
        val fofofofofofofofofofrr = "sub_id_4="
        val frfrfrrf = "sub_id_5="
        val jpjpjpj = "sub_id_6="

        val gtgtgtt = "naming"


        val gtggttg = Build.VERSION.RELEASE

        val frfrfrrfr5: String = Hawk.get(linkfrrr)

        var hhyhyyhyyy = ""
        if (checkFlyfrggt == "1"){
            hhyhyyhyyy =
                "$frfrfrrfr5$subOnefrfr$cpOnegtgtgt&$onefgttg$afIdddddd&$thrhtrhtrhtrhtfrfr$mainIdfrgtt&$fofofofofofofofofofrr$popopo&$frfrfrrf$gtggttg&$jpjpjpj$gtgtgtt"
            frffrrr(afIdddddd.toString())
        } else {
            hhyhyyhyyy =
                "$frfrfrrfr5$onefgttg$myTrIDfrgtt&$thrhtrhtrhtrhtfrfr$myInstIdfgtgt&$fofofofofofofofofofrr$popopo&$frfrfrrf$gtggttg&$jpjpjpj$gtgtgtt"
            frffrrr(myTrIDfrgtt.toString())
        }

        return jujuu.getString("SAVED_URL", hhyhyyhyyy).toString()
    }

    fun saveUrl(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (ggttt == "") {
                ggttt = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }


    private fun oyoyoyoy(uri: String): Boolean {

        val phphphph = packageManager
        try {

            phphphph.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != ftgtgtt || frgtgttgt == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                results = arrayOf(Uri.parse(kgjfhdkxf))
            } else {
                val gtgtgttt = data.dataString
                if (gtgtgttt != null) {
                    results = arrayOf(Uri.parse(gtgtgttt))
                }
            }
        }
        frgtgttgt?.onReceiveValue(results)
        frgtgttgt = null
    }


    private var frfrrfr = false
    override fun onBackPressed() {


        if (mmo.canGoBack()) {
            if (frfrrfr) {
                mmo.stopLoading()
                mmo.loadUrl(ggttt)
            }
            this.frfrrfr = true
            mmo.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                frfrrfr = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    var ggttt = ""

}