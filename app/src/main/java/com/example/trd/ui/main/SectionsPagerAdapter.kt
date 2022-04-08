package com.example.trd.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.trd.R
import com.example.trd.category_fragment
import com.example.trd.items_list


private val TAB_TITLES = arrayOf(
    //this array stores the tab names to appear on the tabview

        R.string.tab_text_1,
        R.string.tab_text_2
)

private val frags = arrayListOf(
    //this one stores the fragments you want  to be output in the viewpager

    items_list(),
    category_fragment()
)
/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        ///this method returns the fragments stored in the array in order of their storage by index lol


        //hii return mthd ya kwanza ndio nilikuwa nadhani itafanya but imezua
        //imeweza btw😅 nilikuwa nimeblunder mahali
    return frags.get(index = position)
    }

    override fun getPageTitle(position: Int): CharSequence {
        //return the tab you wanna output that's stored in the tab array

        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show all pages.
        return 2
    }
}