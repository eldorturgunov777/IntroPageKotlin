package com.example.intropagekotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener

class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager? = null
    var adapter: IntroViewPagerAdapter? = null
    var tabIndicator: TabLayout? = null
    var btnSkip: Button? = null
    var btnGetStarted: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        btnSkip = findViewById(R.id.btn_skip)
        btnGetStarted = findViewById(R.id.btn_get_started)

        tabIndicator = findViewById(R.id.tab_indicator)

        val list: MutableList<ScreenItem> = ArrayList()
        list.add(
            ScreenItem(
                "Lorem Ipsum",
                "Lorem Ipsum is simply dummy text of the printing and typesetting\nindustry. Lorem Ipsum has been the industry's",
                R.drawable.agreement
            )
        )
        list.add(
            ScreenItem(
                "Lorem Ipsum",
                "Lorem Ipsum is simply dummy text of the printing and typesetting\nindustry. Lorem Ipsum has been the industry's",
                R.drawable.document
            )
        )
        list.add(
            ScreenItem(
                "Lorem Ipsum",
                "Lorem Ipsum is simply dummy text of the printing and typesetting\nindustry. Lorem Ipsum has been the industry's",
                R.drawable.startup
            )
        )

        viewPager = findViewById(R.id.screen_viewpager)
        adapter = IntroViewPagerAdapter(this, list)
        viewPager?.setAdapter(adapter)
        tabIndicator?.setupWithViewPager(viewPager)

        btnSkip?.setOnClickListener(View.OnClickListener { view: View? ->
            viewPager?.setCurrentItem(
                list.size
            )
        })
        tabIndicator?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (tab == list.size - 1) {
                    loadLastScreen()
//                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }


        })
        btnGetStarted?.setOnClickListener(View.OnClickListener { view: View? ->
            val mainActivity = Intent(
                applicationContext,
                HomeActivity::class.java
            )
            startActivity(mainActivity)
            finish()
        })
    }


    open fun loadLastScreen() {
        btnSkip?.setVisibility(View.INVISIBLE)
        btnGetStarted?.setVisibility(View.VISIBLE)
    }


}