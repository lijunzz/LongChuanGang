package net.junzz.app.lcg

import android.provider.BaseColumns

object LcgContract {

    object LcgEntry : BaseColumns {
        val TABLE_NAME = "lists"
        /** 名称 */
        val COLUMN_NAME_TITLE = "title"
        /** 备注 */
        val COLUMN_NAME_REMARK = "remark"
    }
}