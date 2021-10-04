package com.nurkholiq.scrolling_activity

import android.os.Bundle
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.nurkholiq.scrolling_activity.databinding.ActivityDetailBinding
import kotlin.math.abs

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(findViewById(R.id.toolbar))
////        binding.toolbarLayout.title = title
//        binding.toolbarLayout.title = "Scrolling Activity"
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        val myName = "Nurkholiq Agani Hafid"
        val myRole = "Android"
        val avatar = R.drawable.img_kotlin_android

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.imgAvatar.setImageDrawable(ContextCompat.getDrawable(this, avatar))
        binding.tvTitle.text = myName
        binding.tvRole.text = myRole

        binding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                // COLLAPSED KETIKA DI TUTUP
                Log.e("appBarLayout", "collapsed")
                binding.toolbarLayout.title = myName
            } else {
                // EXPANDED KETIKA DI BUKA
                Log.e("appBarLayout", "expanded")
                binding.toolbarLayout.title = ""
            }
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}