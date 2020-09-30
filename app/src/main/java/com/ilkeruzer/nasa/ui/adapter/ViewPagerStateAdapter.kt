package com.ilkeruzer.nasa.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ilkeruzer.nasa.ui.fragment.curiosity.CuriosityFragment
import com.ilkeruzer.nasa.ui.fragment.opportunity.OpportunityFragment
import com.ilkeruzer.nasa.ui.fragment.spirit.SpiritFragment

class ViewPagerStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments:ArrayList<Fragment> = arrayListOf(
        CuriosityFragment(),
        OpportunityFragment(),
        SpiritFragment()
    )


    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}