package com.danny.bookone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.danny.bookone.Base.StringAdapter
import com.danny.bookone.aac.AacActivity
import com.danny.bookone.one.HeroActivity
import com.danny.bookone.other.CompanyActivity
import com.danny.bookone.other.DataActivity
import com.danny.bookone.other.HandlerActivity
import com.danny.bookone.highLight.HighLightActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val chapters = arrayOf(
            "Android群英传",
            "Android进阶之光",
            "AAC系列",
            "handler原理解析",
            "java数据结构",
            "Android四大组件")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val stringList: List<String> = ArrayList(Arrays.asList(*chapters)) as List<String>
        val adapter = StringAdapter(stringList)
        rcv_chapter.layoutManager = LinearLayoutManager(this@MainActivity)
        rcv_chapter.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        rcv_chapter.adapter = adapter
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when (position) {
                0 -> startActivity(HeroActivity.createIntent(this@MainActivity))//Android群英传
                1 -> startActivity(HighLightActivity.createIntent(this@MainActivity))//android进阶之光
                2 -> startActivity(AacActivity.createIntent(this@MainActivity))//Jetpack架构篇
                3 -> startActivity(HandlerActivity.createIntent(this@MainActivity))//handler线程篇
                4 -> startActivity(DataActivity.createIntent(this@MainActivity))//数据结构篇。hashMap
                5 -> startActivity(CompanyActivity.createIntent(this@MainActivity))//android基础组件篇。服务，广播，activity
            }
        }
    }
}