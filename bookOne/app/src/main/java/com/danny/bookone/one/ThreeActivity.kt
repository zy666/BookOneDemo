package com.danny.bookone.one

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.danny.bookone.R

class ThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
    }


    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, ThreeActivity::class.java)
        }
    }
}