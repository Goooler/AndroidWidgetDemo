package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Picture
import android.graphics.RectF
import android.graphics.drawable.PictureDrawable
import android.util.AttributeSet
import android.view.View

class PictureView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val picture = Picture()
  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    val canvas = picture.beginRecording(w, h)
    canvas.drawCircle(0f, 0f, 200f, paint)
    picture.endRecording()
  }

  override fun onDraw(canvas: Canvas) {
    canvas.translate(width / 2f, 200f)
    picture.draw(canvas)
    canvas.translate(0f, 220f)
    canvas.drawPicture(picture, RectF(0f, 0f, width / 2f, height / 2f))
    canvas.translate(0f, 220f)
    PictureDrawable(picture).let {
      it.setBounds(0, 0, width / 2, height / 2)
      it.draw(canvas)
    }
  }
}