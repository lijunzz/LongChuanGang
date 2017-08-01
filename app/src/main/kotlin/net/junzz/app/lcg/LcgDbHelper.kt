package net.junzz.app.lcg

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LcgDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_LISTS)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "lcg.db"

        /** 创建 lists 表 */
        private val SQL_CREATE_LISTS =
                "CREATE TABLE ${LcgContract.LcgEntry.TABLE_NAME} (" +
                        "${LcgContract.LcgEntry.COLUMN_NAME_TITLE} TEXT PRIMARY KEY," +
                        "${LcgContract.LcgEntry.COLUMN_NAME_REMARK} TEXT)"
    }
}