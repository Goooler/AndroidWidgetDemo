package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.blankj.utilcode.util.ImageUtils
import io.goooler.android.widgetdemo.R

class CircleImageView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val radius = 200
  private val padding = 20f
  private val avatar: Bitmap = ImageUtils.getBitmap(R.drawable.avatar)

  override fun onDraw(canvas: Canvas) {
    canvas.drawBitmap(avatar, padding, padding, paint)
  }
}