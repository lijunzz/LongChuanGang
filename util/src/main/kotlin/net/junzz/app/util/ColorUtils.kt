package net.junzz.app.util

import java.util.*

/**
 * 颜色工具类
 */
object ColorUtils {

    fun newRandomColor(): String {
        var r: String
        var g: String
        var b: String
        val random = Random()
        r = Integer.toHexString(random.nextInt(256)).toLowerCase()
        g = Integer.toHexString(random.nextInt(256)).toLowerCase()
        b = Integer.toHexString(random.nextInt(256)).toLowerCase()
        r = if (r.length == 1) "0$r" else r
        g = if (g.length == 1) "0$g" else g
        b = if (b.length == 1) "0$b" else b
        return "#$r$g$b"
    }

}
