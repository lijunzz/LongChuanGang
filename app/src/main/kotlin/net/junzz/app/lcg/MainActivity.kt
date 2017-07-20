package net.junzz.app.lcg

import android.app.Activity
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewpager = ViewPager(this)
        setContentView(viewpager)

        val favoriteView = initFavoritePage()
        val listView = initListPage()
        val views = listOf(favoriteView, listView)
        viewpager.adapter = MainPagerAdapter(views)
        viewpager.currentItem = 1
    }

    /** 收藏夹 */
    private fun initFavoritePage(): View {
        val emptyView = TextView(this)
        emptyView.text = "空"
        emptyView.textSize = 32f
        emptyView.gravity = Gravity.CENTER
        emptyView.typeface = Typeface.DEFAULT_BOLD
        emptyView.setTextColor(Color.BLACK)
        return emptyView
    }

    /** 列表 */
    private fun initListPage(): View {
        val listView = RecyclerView(this)
        listView.layoutManager = LinearLayoutManager(this)
        val listData = mutableListOf("AAA", "BBB", "CCC")
        val listAdapter = ListAdapter(listData)
        listView.adapter = listAdapter
        return listView
    }
}