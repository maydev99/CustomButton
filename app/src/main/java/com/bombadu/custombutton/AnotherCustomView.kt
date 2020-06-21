package com.bombadu.custombutton

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

private enum class ButtonState(val label: Int) {
    OFF(R.string.button_off),
    ON(R.string.button_on);


    fun next() = when (this) {
        OFF -> ON
        ON -> OFF
    }
}

class AnotherCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var textSize = 0.0f

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 35.0f
        color = Color.RED
        typeface = Typeface.create("", Typeface.BOLD)
    }

    private val buttonOnPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.BLUE
    }

    private val buttonOffPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.YELLOW
    }

    init {
        isClickable = true

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        textSize = (min(w,h) / 3.0).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 2).toFloat(), buttonOffPaint)
    }



}