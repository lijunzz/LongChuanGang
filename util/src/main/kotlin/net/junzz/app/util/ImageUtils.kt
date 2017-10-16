package net.junzz.app.util

import android.view.View
import android.widget.ImageView

/**
 * 图片工具类
 */
object ImageUtils {

    /**
     * 加载圆形头像
     */
    fun showAvatar(context: View, avatar: Any, view: ImageView) {
        GlideApp.with(context)
                .load(avatar)
                .circleCrop()
                .into(view)
    }

}
