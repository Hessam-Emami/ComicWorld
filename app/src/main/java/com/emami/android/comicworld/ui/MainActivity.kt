package com.emami.android.comicworld.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.emami.android.comicworld.R
import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.databinding.ActivityMainBinding
import com.emami.android.comicworld.service.PicassoImageService
import com.emami.android.comicworld.ui.explore.adapter.BannerSliderAdapter
import com.emami.android.comicworld.ui.explore.adapter.ExploreListAdapter
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
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
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
        val adapter = ExploreListAdapter()
        binding.newRecyclerView.adapter = adapter

        val ref2 = database.getReference("Comic")

        ref2.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("MainActivity",p0.message)

            }

            override fun onDataChange(p0: DataSnapshot) {
                val list:List<Comic> = p0.children.map {
                    Comic(
                        it.child("Name").value as String,
                        it.child("Image").value as String
                    )

                 }
                adapter.submitList(list)

            }

        })


    }
}
