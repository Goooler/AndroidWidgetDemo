package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class DashboardView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val path = Path()

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    path.addCircle(w / 2f, h / 2f, RADIUS, Path.Direction.CW)
  }

  override fun onDraw(canvas: Canvas) {
    canvas.drawPath(path, paint)
  }

  companion object {
    private const val RADIUS = 200f
  }
}