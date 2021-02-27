package io.goooler.android.widgetdemo.util

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes

fun Resources.getBitmap(@DrawableRes drawableRes: Int, width: Int): Bitmap {
  val options = BitmapFactory.Options().also {
    it.inJustDecodeBounds = true
    BitmapFactory.decodeResource(this, drawableRes, it)
    it.inJustDecodeBounds = false
    it.inDensity = it.outWidth
    it.inTargetDensity = width
  }
  return BitmapFactory.decodeResource(this, drawableRes, options)
}