package com.ril.fieldtravelclone

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltFieldTravelApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}