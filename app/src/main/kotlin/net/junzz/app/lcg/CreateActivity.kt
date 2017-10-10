package net.junzz.app.lcg

import android.content.ContentValues
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import net.junzz.app.lcg.common.logDebug
import net.junzz.app.lcg.common.toJson

class CreateActivity : AppCompatActivity() {

    private lateinit var mDbHelper: LcgDbHelper

    private lateinit var mAdapter: CreateAdapter

    private lateinit var mTitleView: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_activity)

        mDbHelper = LcgDbHelper(this)

        val listView = findViewById(R.id.rv_create_list) as RecyclerView
        listView.layoutManager = LinearLayoutManager(this)
        mAdapter = CreateAdapter()
        listView.adapter = mAdapter

        mTitleView = findViewById(R.id.edt_create_title) as TextInputEditText
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.create_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.insert -> {
                mAdapter.insertItem(CreateItemDO())
                return true
            }
            R.id.save -> {
                logDebug("save:${toJson(List::class.java, mAdapter.data)}")
                saveContents()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    /**
     * 保存内容到数据库
     */
    private fun saveContents() {
        val content = mTitleView.text.toString()

        if (content.isNullOrEmpty()) {
            mTitleView.error = "必填项"
            return
        }

        val db = mDbHelper.writableDatabase

        val values = ContentValues()
        values.put(LcgContract.LcgEntry.COLUMN_NAME_TITLE, content)
        values.put(LcgContract.LcgEntry.COLUMN_NAME_REMARK, toJson(List::class.java, mAdapter.data))

        val newRowId = db.insert(LcgContract.LcgEntry.TABLE_NAME, null, values)
        logDebug("newRowId:$newRowId")

        db.close()
    }

}