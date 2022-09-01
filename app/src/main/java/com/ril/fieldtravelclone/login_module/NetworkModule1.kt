package com.ril.fieldtravelclone.login_module
import retrofit2.converter.scalars.ScalarsConverterFactory

import android.net.Uri
import com.ril.fieldtravelclone.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule1 {

    @Provides
    @Singleton
    fun provideHTTPClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        val serverHost= Uri.parse(BuildConfig.BASE_URL).host
        var certificatePinner=CertificatePinner.Builder().
        add(serverHost!!, "sha256/"+BuildConfig.pinset_base).
        add(serverHost!!, "sha256/"+BuildConfig.insetp1_version).
        add(serverHost!!, "sha256/"+BuildConfig.insetp1_version).build()
        return OkHttpClient.Builder().certificatePinner(
            certificatePinner
        ).addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level= HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder().
        baseUrl("https://apimhc.ril.com/oauth2/").
        addConverterFactory(ScalarsConverterFactory.create()).
        addConverterFactory(GsonConverterFactory.create()).
            client(okHttpClient).
        build()
    }

    @Provides
    fun provideAPIClient(retrofit: Retrofit): APIInterface1 {
        return retrofit.create(APIInterface1::class.java)
    }
}