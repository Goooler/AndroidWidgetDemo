package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt

class PieChartView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val path = Path()
  private val models = mutableListOf<PieChartModel>()
  private val rectF = RectF()
  private var lastAngle = 0F

  var radius = 0F

  fun setModels(vararg models: PieChartModel) {
    this.models.addAll(models)
  }

  override fun onDraw(canvas: Canvas) {
    models.forEach {
      paint.color = it.color
      canvas.drawArc(
        RectF(
          width / 2 - radius,
          height / 2 - radius,
          width / 2 + radius,
          height / 2 + radius
        ), lastAngle, it.percentage * 360, true, paint
      )
      lastAngle += it.percentage * 360
    }
  }

  class PieChartModel(
    @ColorInt val color: Int,
    val percentage: Float
  )
}