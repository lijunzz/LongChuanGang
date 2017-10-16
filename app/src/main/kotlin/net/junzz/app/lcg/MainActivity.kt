package net.junzz.app.lcg

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

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
        emptyView.setTextColor(Color.parseColor("#A9B7C6"))
        return emptyView
    }

    /** 列表 */
    private fun initListPage(): View {
        val listView = RecyclerView(this)
        listView.layoutManager = LinearLayoutManager(this)
        val listData = mutableListOf<String>()

        val dbHelper = LcgDbHelper(this)
        val db = dbHelper.writableDatabase

        // 待查询项
        val projection = arrayOf(LcgContract.LcgEntry.COLUMN_NAME_TITLE, LcgContract.LcgEntry.COLUMN_NAME_REMARK)
        val cursor = db.query(LcgContract.LcgEntry.TABLE_NAME, projection, null, null, null, null, null)
        with(cursor) {
            while (moveToNext()) {
                val title = getString(getColumnIndexOrThrow(LcgContract.LcgEntry.COLUMN_NAME_TITLE))
                val mark = getString(getColumnIndexOrThrow(LcgContract.LcgEntry.COLUMN_NAME_REMARK))
                listData.add("$title : $mark")
            }
            close()
        }
        db.close()

        val listAdapter = ListAdapter(listData)
        listView.adapter = listAdapter
        return listView
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.info_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create -> {
                startActivity(Intent(this, CreateActivity::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}