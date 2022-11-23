package com.trophymanager.pro

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterfaaaaaaaace {

    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getData(): Response<CountryCodeJS>

    @GET("const.json")
    suspend fun getDataDev(): Response<GeoDev>
}
@Keep
data class CountryCodeJS(
    @SerializedName("city")
    val frrr: String,
    @SerializedName("country")
    val frfrfr: String,
    @SerializedName("countryCode")
    val countryCodedrfr: String,
)
@Keep
data class GeoDev(
    @SerializedName("geo")
    val geofrrr: String,
    @SerializedName("view")
    val viewfrrr: String,
    @SerializedName("appsChecker")
    val appsCheckerfrrr: String,
)