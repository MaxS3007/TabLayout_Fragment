package com.example.tablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tablayoutapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding

    private val fragList = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance())
    private val fragText = listOf(
        "",
        "",
        "")

    private val fragIcon = listOf(
        R.drawable.icon1,
        R.drawable.icon1,
        R.drawable.icon1)

    private val fragBadge = listOf(
        15,
        23,
        111)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val adapter = VpAdapter(this, fragList)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.tabLayout, bind.vp2){
            tab, pos ->
            tab.text = fragText[pos]
            tab.icon = ContextCompat.getDrawable(this, fragIcon[pos])
            val badge = tab.orCreateBadge
            badge.number = fragBadge[pos]
        }.attach()


    }
}