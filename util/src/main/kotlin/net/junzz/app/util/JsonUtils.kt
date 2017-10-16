package net.junzz.app.util

import com.squareup.moshi.Moshi

/**
 * JSON 工具类
 */
object JsonUtils {

    fun <T> toJson(type: Class<T>, value: T) = Moshi.Builder().build().adapter(type).toJson(value)
}
