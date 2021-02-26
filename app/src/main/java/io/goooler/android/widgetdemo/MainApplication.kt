package io.goooler.android.widgetdemo

import android.app.Application

class MainApplication : Application() {

  override fun onCreate() {
    super.onCreate()
    app = this
  }

  companion object {
    lateinit var app: Application
      private set
  }
}