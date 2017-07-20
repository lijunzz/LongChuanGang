package net.junzz.app.lcg

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class MainPagerAdapter(val views: List<View>) : PagerAdapter() {

    override fun isViewFromObject(view: View?, `object`: Any?) = (view == `object`)

    override fun getCount() = views.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = views[position]
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any?) {
        container.removeView(`object` as View)
    }
}