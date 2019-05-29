package com.emami.android.comicworld

import android.graphics.Outline
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.emami.android.comicworld.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ss.com.bannerslider.Slider

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
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        textMessage = findViewById(R.id.textww)
//        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        binding.bol = true
        Slider.init(PicassoImageService())

        val sliderView:Slider = binding.bannerSlider



        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("Banners")
        Log.d("MainActivity","test")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("MainActivity",p0.message)
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list = p0.children.map { it.value.toString()}
                Log.d("MainActivity",list.size.toString())
                sliderView.setAdapter(BannerSliderAdapter(list))
            }
        })
    }
}
