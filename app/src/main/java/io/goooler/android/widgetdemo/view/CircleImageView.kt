package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.view.View
import io.goooler.android.widgetdemo.R
import io.goooler.android.widgetdemo.util.getBitmap

class CircleImageView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val radius = 500
  private val padding = 20f
  private val avatar: Bitmap = resources.getBitmap(R.drawable.avatar, radius)
  private val xferMode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
  private val path = Path().apply {
    addCircle(padding + radius / 2, padding + radius / 2, radius.toFloat() / 2, Path.Direction.CCW)
  }

  override fun onDraw(canvas: Canvas) {
    val layer = canvas.saveLayer(padding, padding, padding + radius, padding + radius, null)
    canvas.drawOval(padding, padding, padding + radius, padding + radius, paint)
    paint.xfermode = xferMode
    canvas.drawBitmap(avatar, padding, padding, paint)
    paint.xfermode = null
    canvas.restoreToCount(layer)

    canvas.translate(0f, padding + radius)
    canvas.clipPath(path)
    canvas.drawBitmap(avatar, padding, padding, paint)
  }
}