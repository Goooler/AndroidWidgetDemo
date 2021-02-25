package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.view.View
import io.goooler.android.widgetdemo.R

class CircleImageView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val radius = 500
  private val padding = 20f
  private val avatar: Bitmap = getAvatar(radius)
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

  private fun getAvatar(width: Int): Bitmap {
    val options = BitmapFactory.Options().also {
      it.inJustDecodeBounds = true
      BitmapFactory.decodeResource(resources, R.drawable.avatar, it)
      it.inJustDecodeBounds = false
      it.inDensity = it.outWidth
      it.inTargetDensity = width
    }
    return BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
  }
}