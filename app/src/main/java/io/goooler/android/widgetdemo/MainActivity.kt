package io.goooler.android.widgetdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.goooler.android.widgetdemo.databinding.ActivityMainBinding
import io.goooler.android.widgetdemo.util.showToast

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  fun showToast(v: View) {
    "custom view show toast".showToast()
  }
}