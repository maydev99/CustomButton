package com.bombadu.custombutton

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes

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

    private var buttonOffColor = 0
    private var buttonOnColor = 0
    private var buttonState = ButtonState.OFF



    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        typeface = Typeface.create("", Typeface.BOLD)



    }


    init {
        isClickable = true

        context.withStyledAttributes(attrs, R.styleable.CoolButtonView) {
            buttonOffColor = getColor(R.styleable.CoolButtonView_buttonColor1, 0)
            buttonOnColor = getColor(R.styleable.CoolButtonView_buttonColor2, 0)

        }

    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        buttonState = buttonState.next()
        contentDescription = resources.getString(buttonState.label)
        invalidate()

        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = when(buttonState) {

            ButtonState.OFF -> buttonOffColor
            ButtonState.ON -> buttonOnColor
        }


        //paint.setShadowLayer((width /2).toFloat(),(height / 2).toFloat(),12.0f,Color.DKGRAY)
        canvas!!.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 2).toFloat(), paint)

        for (i in ButtonState.values()) {
            val label = resources.getString(buttonState.label)
            paint.color = Color.WHITE
            paint.textSize = (width / 3).toFloat()
            canvas.drawText(label, (width / 2).toFloat(), (height / 1.6).toFloat(), paint)
        }

    }



}