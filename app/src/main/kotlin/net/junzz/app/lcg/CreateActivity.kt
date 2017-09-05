package net.junzz.app.lcg

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView = RecyclerView(this)
        setContentView(listView)

        listView.layoutManager = LinearLayoutManager(this)
        val listData = mutableListOf<CreateItemDO>()

        listData.add(CreateItemDO("", ""))
        listData.add(CreateItemDO("", ""))
        listData.add(CreateItemDO("", ""))
        listData.add(CreateItemDO("", ""))
        listData.add(CreateItemDO("", ""))
        listData.add(CreateItemDO("", ""))

        val adapter = CreateAdapter(listData)
        listView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.create_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}