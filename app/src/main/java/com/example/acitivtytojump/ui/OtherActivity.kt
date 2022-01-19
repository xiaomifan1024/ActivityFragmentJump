package com.example.acitivtytojump.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.acitivtytojump.R
import com.example.acitivtytojump.TestActivity
import com.example.acitivtytojump.databinding.ActivityOtherBinding
import com.example.acitivtytojump.databinding.FragmentHomeBinding

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        val button =findViewById<Button>(R.id.toOther2Activity)
        button.setOnClickListener {
            var intent = Intent(this, Other2Activity().javaClass)
            startActivity(intent)
        }
    }
}