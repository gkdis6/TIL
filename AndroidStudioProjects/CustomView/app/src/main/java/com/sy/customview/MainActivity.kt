package com.sy.customview

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.sy.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customView = CustomView("안녕 코틀린!",this)
        binding.frameLayout.addView(customView)


    }
}

class CustomView(text: String, context: Context): View(context){
    val text: String
    init {
        this.text = text
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 100f
        canvas?.drawText(text, 0f, 100f, paint) //drawText 메서드린

        val blueCircle = Paint()
        blueCircle.style = Paint.Style.FILL
        blueCircle.color = Color.BLUE
        canvas?.drawCircle(150f, 300f, 100f, blueCircle)

        val redArc = Paint()
        redArc.style = Paint.Style.STROKE
        redArc.color = Color.RED
        canvas?.drawCircle(400f, 300f, 100f,redArc)

        val greenRect = Paint()
        greenRect.style = Paint.Style.STROKE
        greenRect.strokeWidth = 20f
        greenRect.color = Color.GREEN
        val rect = RectF(50f, 450f, 250f, 650f)
        canvas?.drawRect(rect, greenRect)

        val cyanRound = Paint()
        cyanRound.style = Paint.Style.FILL
        cyanRound.color = Color.CYAN
        val rectF = RectF(300f, 450f, 500f, 650f)
        canvas?.drawRoundRect(rectF, 50f, 50f, cyanRound)
    }
}
