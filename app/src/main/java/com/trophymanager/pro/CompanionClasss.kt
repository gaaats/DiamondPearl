package com.trophymanager.pro

import android.app.Application
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import java.util.*

class CompanionClasss:Application() {

    companion object {
        const val gtgtt = "eb6c0953-d48a-4354-90d2-af66ae2b860a"
        const val dfwthyhyj = "41914813864607740923"

        var apapap = "appsChecker"
        var frrfrr: String? = "instID"
        var linkfrrr = "link"
        var MAIN_IDfrrrr: String? = ""
        var froofrfo: String? = "c11"
        var frfrrfr: String? = "myID"

    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(gtgtt)

        Hawk.init(this).build()


        val settingsfrr = getSharedPreferences("PREFS_NAME", 0)

        val trackerParamsfrrr = MyTracker.getTrackerParams()
        val gfrrrr = MyTracker.getTrackerConfig()
        val instIDfrr = MyTracker.getInstanceId(this)
        gfrrrr.isTrackingLaunchEnabled = true
        if (settingsfrr.getBoolean("my_first_time", true)) {
            val IDINfrrr = UUID.randomUUID().toString()
            trackerParamsfrrr.setCustomUserId(IDINfrrr)
            Hawk.put(frfrrfr, IDINfrrr)
            Hawk.put(frrfrr, instIDfrr)
            settingsfrr.edit().putBoolean("my_first_time", false).apply()

        } else {
            val fgrrrrr = Hawk.get(frfrrfr, "null")
            trackerParamsfrrr.setCustomUserId(fgrrrrr)
        }
        MyTracker.initTracker(dfwthyhyj, this)

    }


}
