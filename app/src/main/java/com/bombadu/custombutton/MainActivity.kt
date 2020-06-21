package com.bombadu.custombutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customButtonViewBottom.setOnClickListener {
            val text = expandableHintText.text.toString()
            if(text == "Cate") {
                startActivity(Intent(this, AnotherActivity::class.java))
            }

        }
    }
}