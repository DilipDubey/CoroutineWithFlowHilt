package com.ril.fieldtravelclone.login_module

import com.ril.fieldtravelclone.BuildConfig
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface APIInterface1 {

    @FormUrlEncoded
    @POST("token")
    suspend fun login(@Header("Content-Type") content_type:String,
                      @Header("Authorization")  auth:String,
                      @Field("grant_type") grant_type:String,
                      @Field("username")  username:String,
                      @Field("password")  password:String,
                      @Field("scope")  scope:String):String
}