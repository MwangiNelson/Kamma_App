package com.example.trd

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trd.ui.main.SectionsPagerAdapter
import com.example.trd.databinding.ActivityMktBinding

class mkt_activity : AppCompatActivity() {

    private lateinit var binding: ActivityMktBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }





        binding = ActivityMktBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)


    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

}