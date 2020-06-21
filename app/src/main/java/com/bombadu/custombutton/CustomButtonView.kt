package com.bombadu.custombutton

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomButtonView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val mPaint1 = Paint()
    private var mPaint2 = Paint()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint1.color = Color.RED
        mPaint2.color = Color.BLACK
        mPaint2 = Paint(Paint.ANTI_ALIAS_FLAG)

        if (!isClicked) {

            canvas!!.drawRect(0f, 0f, 300f, 150f, mPaint2)
            canvas.drawPaint(mPaint2)
            canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), 75f, mPaint1)
            canvas.drawText(
                "On",
                ((width / 2) - (55)).toFloat(),
                (height * 0.90).toFloat(),
                textPaint
            )
            isClicked = true
        } else {
            canvas!!.drawRect(0f, 0f, 300f, 150f, mPaint1)
            canvas.drawPaint(mPaint1)
            canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), 75f, mPaint2)
            canvas.drawText(
                "Off",
                ((width / 2) - (55)).toFloat(),
                (height * 0.90).toFloat(),
                textPaint
            )
            isClicked = false
        }


    }

    companion object {
        var isClicked = false
    }

    init {
        isClickable = true

    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true

        invalidate()

        return true
    }

    private val textPaint =
        Paint().apply {
            isAntiAlias = true
            textSize = 80f
            if (!isClicked) {
                color = Color.WHITE
            } else {
                color = Color.WHITE
            }



        }
}