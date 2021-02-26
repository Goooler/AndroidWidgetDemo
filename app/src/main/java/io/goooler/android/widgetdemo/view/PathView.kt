package io.goooler.android.widgetdemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PathMeasure
import android.util.AttributeSet
import android.view.View

class PathView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
  private val path = Path()
  private val dst = Path()
  private lateinit var measure: PathMeasure

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

    dst.addCircle(-300f, 0f, 100f, Path.Direction.CW)

    measure = PathMeasure(path, false)
    // 如果 startWithMoveTo 为 true, 则被截取出来到Path片段保持原状，如果 startWithMoveTo 为 false，
    // 则会将截取出来的 Path 片段的起始点移动到 dst 的最后一个点，以保证 dst 的连续性
    measure.getSegment(100f, 500f, dst, false)
  }

  override fun onDraw(canvas: Canvas) {
    canvas.translate(width / 2f, 300f)
    canvas.drawPath(path, paint)

    canvas.translate(0f, 300f)
    canvas.drawPath(dst, paint)
  }
}