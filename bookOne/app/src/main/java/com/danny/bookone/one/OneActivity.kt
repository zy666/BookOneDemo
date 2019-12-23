package com.danny.bookone.one

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danny.bookone.R

class OneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, OneActivity::class.java)
        }
    }
}
