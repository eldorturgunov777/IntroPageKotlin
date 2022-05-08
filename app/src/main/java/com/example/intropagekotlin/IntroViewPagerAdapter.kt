package com.example.intropagekotlin

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class IntroViewPagerAdapter(val context: Context, var list: List<ScreenItem>) :
    PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        val view = inflater.
            .inflate(context, R.layout.layout_screen_design, null)

        val imgSlide: ImageView = view.findViewById(R.id.intro_img)
        val title: TextView = view.findViewById(R.id.intro_title)
        val description: TextView = view.findViewById(R.id.intro_description)

        title.setText(list.get(position))
        description.setText(list.get(position))
        imgSlide.setImageResource(list.get(position))

        container.addView(view)

        return view


    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}