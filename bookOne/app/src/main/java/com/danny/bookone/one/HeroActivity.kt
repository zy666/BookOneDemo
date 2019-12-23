package com.danny.bookone.one

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.danny.bookone.Base.StringAdapter
import com.danny.bookone.R
import com.danny.bookone.databinding.ActivityHeroBinding

import java.util.ArrayList
import java.util.Arrays

/**
 * 《android群英传》
 */
class HeroActivity : AppCompatActivity() {
    private var heroBinding: ActivityHeroBinding? = null
    private val chapters = arrayOf("第一章", "第二章", "第三章", "第四章",
            "第五章", "第六章", "第七章-Android动画机制与使用技巧", "第八章",
            "第九章", "第十章", "第十一章", "第十二章", "第十三章")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        heroBinding = DataBindingUtil.setContentView(this, R.layout.activity_hero)

        val stringList = ArrayList(Arrays.asList(*chapters))
        val adapter = StringAdapter(stringList)
        heroBinding!!.rcvData.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        heroBinding!!.rcvData.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        heroBinding!!.rcvData.adapter = adapter
        adapter.onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { adapter, view, position ->
            when (position) {
                0 -> startActivity(OneActivity.createIntent(this@HeroActivity))
                6 -> startActivity(ChapterSevenActivity.createIntent(this@HeroActivity))
            }
        }

    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, HeroActivity::class.java)
        }
    }

}
