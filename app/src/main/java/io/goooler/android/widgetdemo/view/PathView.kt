package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PathView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val path = Path()

  init {
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 4f
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    path.lineTo(200f, 200f)
    path.lineTo(200f, 0f)
    path.moveTo(100f, 0f)
    path.lineTo(0f, 0f)
    path.lineTo(0f, -200f)
    path.setLastPoint(-200f, -200f)
    path.lineTo(0f, -200f)
    path.close()
  }

  override fun onDraw(canvas: Canvas) {
    canvas.translate(width / 2f, height / 2f)
    canvas.drawPath(path, paint)
  }
}