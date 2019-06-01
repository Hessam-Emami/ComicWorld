package com.emami.android.comicworld.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emami.android.comicworld.R
import com.emami.android.comicworld.ui.explore.ExploreFragment

class MainActivity : AppCompatActivity() {

//    private lateinit var textMessage: TextView
//    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_home -> {
//                textMessage.setText(R.string.title_home)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_dashboard -> {
//                textMessage.setText(R.string.title_dashboard)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_notifications -> {
//                textMessage.setText(R.string.title_notifications)
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ExploreFragment())
            .commitNow()
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        textMessage = findViewById(R.id.textww)
//        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)




    }
}
