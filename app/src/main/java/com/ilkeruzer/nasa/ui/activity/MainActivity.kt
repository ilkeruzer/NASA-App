package com.ilkeruzer.nasa.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.ilkeruzer.nasa.R
import com.ilkeruzer.nasa.databinding.ActivityMainBinding
import com.ilkeruzer.nasa.ui.adapter.ViewPagerStateAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
    }

    private fun initViewPager() {
        val adapter = ViewPagerStateAdapter(supportFragmentManager,lifecycle)
        val names = resources.getStringArray(R.array.titles)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tablayout,binding.viewpager){tab, position ->
            tab.text = names[position]
        }.attach()
    }


}