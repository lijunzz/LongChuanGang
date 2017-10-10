package net.junzz.app.lcg.common

import com.squareup.moshi.Moshi

fun <T> toJson(type: Class<T>, value: T) = Moshi.Builder().build().adapter(type).toJson(value)!!
