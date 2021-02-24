package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathDashPathEffect
import android.graphics.PathEffect
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class DashboardView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val dash = Path()
  private lateinit var effect: PathEffect
  private val path = Path()
  private lateinit var pathMeasure: PathMeasure
  var openAngle: Float = 120f
  var radius: Float = 300f
  var pointerLength: Float = 200f
  var marks: Int = 5
  var pointerMark: Int = 2

  init {
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 3f
    dash.addRect(0f, 20f, 5f, 0f, Path.Direction.CCW)
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    path.addArc(
      width / 2 - radius,
      height / 2 - radius,
      width / 2 + radius,
      height / 2 + radius,
      90 + openAngle / 2,
      360 - openAngle
    )
    pathMeasure = PathMeasure(path, false)
    // Warning: advance & phase have been reversed
    effect =
      PathDashPathEffect(
        dash,
        (pathMeasure.length - 5f) / marks,
        0f,
        PathDashPathEffect.Style.ROTATE
      )
  }

  override fun onDraw(canvas: Canvas) {
    paint.pathEffect = effect
    canvas.drawPath(path, paint)
    paint.pathEffect = null
    canvas.drawPath(path, paint)
    val angle =
      Math.toRadians((90 + openAngle / 2 + (360 - openAngle) / marks * pointerMark).toDouble())
    canvas.drawLine(
      width / 2f,
      height / 2f,
      width / 2f + cos(angle).toFloat() * pointerLength,
      height / 2f + sin(angle).toFloat() * pointerLength,
      paint
    )
    paint.style = Paint.Style.FILL
    canvas.drawCircle(width / 2f, height / 2f, 10f, paint)
  }
}