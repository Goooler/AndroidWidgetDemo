package io.goooler.android.widgetdemo

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.goooler.android.widgetdemo.util.showToast

class MainActivity : AppCompatActivity(R.layout.activity_main) {

  fun showToast(v: View) {
    "custom view show toast".showToast()
  }
}