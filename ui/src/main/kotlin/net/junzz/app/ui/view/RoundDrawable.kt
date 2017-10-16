package net.junzz.app.ui.view

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape

/**
 * 圆形 Drawable
 */
class RoundDrawable constructor(color: Int) : ShapeDrawable(OvalShape()) {

    init {
        paint.color = color
    }
}
