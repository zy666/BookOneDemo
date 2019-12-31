package com.danny.bookone.one

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.danny.bookone.Base.StringAdapter
import com.danny.bookone.R
import com.danny.bookone.one.HeroActivity
import kotlinx.android.synthetic.main.activity_hero.*
import java.util.*

/**
 * 《android群英传》
 */
class HeroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)
        val chapters = arrayOf(
                "第一章-体系与系统架构",
                "第二章-开发工具",
                "第三章-架构控件与自定义控件详解",
                "第四章",
                "第五章",
                "第六章",
                "第七章-Android动画机制与使用技巧",
                "第八章",
                "第九章",
                "第十章",
                "第十一章",
                "第十二章",
                "第十三章"
        )
        val stringList: List<String> = ArrayList(Arrays.asList(*chapters))
        val adapter = StringAdapter(stringList)
        rcv_data.layoutManager = LinearLayoutManager(this)
        rcv_data.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rcv_data.adapter = adapter
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when (position) {
                0 -> startActivity(OneActivity.createIntent(this@HeroActivity))
                1 -> Toast.makeText(this, "暂无重点，先跳过", Toast.LENGTH_LONG).show()
                2 -> startActivity(ThreeActivity.createIntent(this@HeroActivity))
                6 -> startActivity(ChapterSevenActivity.createIntent(this@HeroActivity))
            }
        }
    }

    companion object {
        fun createIntent(context: Context?): Intent {
            return Intent(context, HeroActivity::class.java)
        }
    }
}