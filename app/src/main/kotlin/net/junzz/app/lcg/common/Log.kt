package net.junzz.app.lcg.common

import android.util.Log

/**
 * 日志
 */

val TAG_NAME: String get() = "zhuzhou"

fun logDebug(msg: String) {
    Log.d(TAG_NAME, msg)
}

fun logError(msg: String) {
    Log.d(TAG_NAME, msg)
}