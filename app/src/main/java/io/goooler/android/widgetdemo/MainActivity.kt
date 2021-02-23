package io.goooler.android.widgetdemo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.goooler.android.widgetdemo.databinding.ActivityMainBinding
import io.goooler.android.widgetdemo.util.showToast
import io.goooler.android.widgetdemo.view.PieChartView

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.pieChart.radius = 200f
    binding.pieChart.setModels(
      PieChartView.PieChartModel(Color.RED, 0.3f),
      PieChartView.PieChartModel(Color.GREEN, 0.5f),
      PieChartView.PieChartModel(Color.BLUE, 0.2f)
    )
  }

  fun showToast(v: View) {
    "custom view show toast".showToast()
  }
}