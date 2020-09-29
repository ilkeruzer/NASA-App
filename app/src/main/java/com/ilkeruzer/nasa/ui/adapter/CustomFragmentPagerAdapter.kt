package com.ilkeruzer.nasa.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ilkeruzer.nasa.ui.fragment.CuriosityFragment
import com.ilkeruzer.nasa.ui.fragment.OpportunityFragment
import com.ilkeruzer.nasa.ui.fragment.SpiritFragment


@Suppress("DEPRECATION")
class CustomFragmentPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    var fragment1: CuriosityFragment? = null
    var fragment2: OpportunityFragment? = null
    var fragment3: SpiritFragment? = null


    override fun getPageTitle(position: Int): CharSequence? {
        return "Title - $position"
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> { if (fragment1 == null) fragment1 = CuriosityFragment()
                fragment1 as CuriosityFragment
            }

            1 -> { if (fragment2 == null) fragment2 = OpportunityFragment()
                fragment2 as OpportunityFragment
            }

            else -> { if (fragment3 == null) fragment3 = SpiritFragment()
                fragment3 as SpiritFragment
            }
        }

    }

    override fun getCount(): Int {
        return 3
    }
}