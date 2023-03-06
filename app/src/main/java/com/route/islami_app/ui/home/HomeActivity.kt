package com.route.islami_app.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islami_app.R
import com.route.islami_app.ui.home.fragments.HadithFragment
import com.route.islami_app.ui.home.fragments.QuranFragment
import com.route.islami_app.ui.home.fragments.RadioFragment
import com.route.islami_app.ui.home.fragments.TasbihFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottom_nav_view: BottomNavigationView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottom_nav_view = findViewById(R.id.bottom_navigation_bar)
        bottom_nav_view.setOnItemSelectedListener { menu_item ->
            if (menu_item.itemId == R.id.navigation_quran) {
                pushFragment(QuranFragment())
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, QuranFragment())
//                    .commit()
            } else if (menu_item.itemId == R.id.navigation_hadith) {
                pushFragment(HadithFragment())
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, HadithFragment())
//                    .commit()
            } else if (menu_item.itemId == R.id.navigation_sebha) {
                pushFragment(TasbihFragment())
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, TasbihFragment())
//                    .commit()
            } else if (menu_item.itemId == R.id.navigation_radio) {
                pushFragment(RadioFragment())
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, RadioFragment())
//                    .commit()
            }
            return@setOnItemSelectedListener true
        }
        bottom_nav_view.selectedItemId = R.id.navigation_quran


    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}