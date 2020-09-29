package com.ilkeruzer.nasa.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ilkeruzer.nasa.databinding.ActivityMainBinding
import com.ilkeruzer.nasa.ui.adapter.CustomFragmentPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentPagerAdapter: CustomFragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpUI()
    }

    private fun setUpUI() {
        binding.navigationTab.setTabIndex(0,true)
        fragmentPagerAdapter = CustomFragmentPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = fragmentPagerAdapter
        binding.navigationTab.setViewPager(binding.viewPager)
    }

}