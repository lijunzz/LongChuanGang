package net.junzz.app.util

import android.util.Log

/**
 * 日志工具类
 */
object LogUtils {

    private val TAG = LogUtils.javaClass.simpleName

    private var debug = false

    fun init(debug: Boolean) {
        this.debug = debug
    }

    fun debug(msg: String) {
        if (debug) {
            Log.d(TAG, msg)
        }
    }

    fun error(msg: String) {
        if (debug) {
            Log.e(TAG, msg)
        }
    }

}
