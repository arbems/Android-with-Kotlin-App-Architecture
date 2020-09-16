package com.arbems.folderstructureappandroid

import android.app.Application
import timber.log.Timber

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /**
         * Timber es un logger con una API pequeña y extensible que proporciona una utilidad además de la clase de registro normal de Android.
         */
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}

