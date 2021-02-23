package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.math.pow

class CanvasTransView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val rect1 = RectF(-300f, -300f, 300f, 300f)
  private val rect2 = RectF(0f, 300f, 300f, 0f)

  override fun onDraw(canvas: Canvas) {
    canvas.translate(width / 2f, 300f)
    paint.style = Paint.Style.STROKE
    for (i in 1..20) {
      canvas.drawRect(rect1, paint)
      canvas.scale(0.9f, 0.9f)
    }

    canvas.scale(1.1f.pow(20), 1.1f.pow(20))
    canvas.translate(0f, 720f)
    canvas.drawCircle(0f, 0f, 350f, paint)
    canvas.drawCircle(0f, 0f, 300f, paint)
    for (i in 0 until 360 step 10) {
      canvas.drawLine(0f, 300f, 0f, 350f, paint)
      canvas.rotate(10f)
    }

    canvas.translate(-400f, 400f)
    canvas.drawRect(rect2, paint)
    canvas.skew(1f, 0f)
    canvas.drawRect(rect2, paint)
  }
}