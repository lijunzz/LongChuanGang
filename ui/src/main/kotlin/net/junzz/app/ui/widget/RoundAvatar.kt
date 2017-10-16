package net.junzz.app.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.LayerDrawable
import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View
import net.junzz.app.ui.R
import net.junzz.app.ui.view.RoundDrawable
import net.junzz.app.util.ImageUtils
import net.junzz.app.util.LogUtils

/**
 * 圆形头像
 */
class RoundAvatar : AppCompatImageView {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val defaultDrawable = RoundDrawable(Color.GRAY)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minimumWidth = suggestedMinimumWidth
        val minimumHeight = suggestedMinimumHeight
        var viewWidth = resolveMeasured(widthMeasureSpec, minimumWidth)
        var viewHeight = resolveMeasured(heightMeasureSpec, minimumHeight)

        viewHeight = Math.min(viewWidth, viewHeight)
        viewWidth = viewHeight

        setMeasuredDimension(viewWidth, viewHeight)

        // 设置 Drawable 的宽高，否则直接使用将不显示
        defaultDrawable.intrinsicWidth = viewWidth
        defaultDrawable.intrinsicHeight = viewHeight
    }

    private fun resolveMeasured(measureSpec: Int, desired: Int): Int {
        val result: Int
        val specSize = View.MeasureSpec.getSize(measureSpec)
        when (View.MeasureSpec.getMode(measureSpec)) {
            View.MeasureSpec.UNSPECIFIED -> result = desired
            View.MeasureSpec.AT_MOST -> result = Math.max(specSize, desired)
            View.MeasureSpec.EXACTLY -> result = specSize
            else -> result = specSize
        }

        return result
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        LogUtils.debug("onDraw::$drawable")

        // 默认圆
        // 将会打印 Log 两次，Java 版只打印一次
        if (drawable == null) {
            setImageDrawable(defaultDrawable)
        }
    }

    private fun avatarDrawable(@ColorInt color: Int): LayerDrawable {
        val bgDrawable = RoundDrawable(color)
        val personDrawable = ContextCompat.getDrawable(context, R.drawable.ic_person_white_24dp)
        val layers = arrayOf(bgDrawable, personDrawable)
        return LayerDrawable(layers)
    }

    /**
     * 设置头像
     */
    fun setImageAvatar(avatar: String) {
        try {
            val avatarColor = Color.parseColor(avatar)
            setImageDrawable(avatarDrawable(avatarColor))
        } catch (e: Exception) {
            ImageUtils.showAvatar(this, avatar, this)
        }
    }

}
