package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class DashboardView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val path = Path()

  init {
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 3f
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    path.addCircle(w / 2f, h / 2f, RADIUS, Path.Direction.CW)
    path.addRoundRect(
      w / 2f - RADIUS,
      h / 2f,
      w / 2f + RADIUS,
      h / 2f + RADIUS,
      RADIUS / 3,
      RADIUS / 3,
      Path.Direction.CW
    )
    val rectF = RectF(w / 2f - RADIUS, h / 2f - RADIUS, w / 2f + RADIUS, h / 2f + 3 * RADIUS)
    path.addArc(rectF, 0f, 360f)
  }

  override fun onDraw(canvas: Canvas) {
    canvas.drawPath(path, paint)
  }

  companion object {
    private const val RADIUS = 200f
  }
}