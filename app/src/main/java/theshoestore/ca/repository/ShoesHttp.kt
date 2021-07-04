package theshoestore.ca.repository

import java.lang.Exception
import java.util.concurrent.TimeUnit
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import theshoestore.ca.model.ShoesResult
import theshoestore.ca.util.Constants

object ShoesHttp {
    private val client = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

    fun fetchData() : ShoesResult?{
        val request = Request.Builder()
            .url(Constants.URL_LOAD_SHOES)
            .build()

        try{
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            return Gson().fromJson(json, ShoesResult::class.java)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}