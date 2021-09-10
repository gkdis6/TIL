package com.sy.seoulpubliclibraries

import com.sy.seoulpubliclibraries.data.Library
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

class SeoulOpenApi {
    companion object{
        val DOMAIN = "http://openAPI.seoul.go.kr:8088/"
        val API_KEY = "5373646846676b643833475a7a4862"
    }
}

interface SeoulOpenService{
    @GET("{api_key}/json/SeoulPublicLibraryInfo/1/200")
    fun getLibrary(@Path("api_key") key: String): Call<Library>
}