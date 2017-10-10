package net.junzz.app.lcg

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class LcgDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_LISTS)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${LcgContract.LcgEntry.TABLE_NAME}")
        onCreate(db)
    }

    companion object {
        val DATABASE_VERSION = 2
        val DATABASE_NAME = "lcg.db"

        /** 创建 lists 表 */
        private val SQL_CREATE_LISTS =
                "CREATE TABLE ${LcgContract.LcgEntry.TABLE_NAME} (" +
                        "${LcgContract.LcgEntry.COLUMN_NAME_TITLE} TEXT PRIMARY KEY," +
                        "${LcgContract.LcgEntry.COLUMN_NAME_REMARK} TEXT)"
    }
}