package com.example.acitivtytojump

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.acitivtytojump.ui.mainfragement.FirstFragment
import com.example.acitivtytojump.ui.mainfragement.SecondFragment


class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val id = this.intent?.getIntExtra("id", 0)
        if (id == 1) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_ll, FirstFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}