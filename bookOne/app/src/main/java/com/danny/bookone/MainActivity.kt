package com.danny.bookone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.danny.bookone.Base.StringAdapter
import com.danny.bookone.aac.AacActivity
import com.danny.bookone.one.HeroActivity
import com.danny.bookone.two.HighLightActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val chapters = arrayOf(
            "Android群英传",
            "Android进阶之光",
            "AAC系列")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stringList: List<String> = ArrayList(Arrays.asList(*chapters))
        val adapter = StringAdapter(stringList)
        rcv_chapter.layoutManager = LinearLayoutManager(this@MainActivity)
        rcv_chapter.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        rcv_chapter.adapter = adapter
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when (position) {
                0 -> startActivity(HeroActivity.createIntent(this@MainActivity))
                1 -> startActivity(HighLightActivity.createIntent(this@MainActivity))
                2 -> startActivity(AacActivity.createIntent(this@MainActivity))
            }
        }
    }
}