package com.example.fragmentapp5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private fun loadFragment(fragment: Fragment) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, fragment)
        ft.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var navigation: BottomNavigationView = findViewById(R.id.navigation)
        navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment.getInstance())
                    true
                }

                R.id.navigation_dashboard -> {
                    loadFragment(DashboardFragment.getInstance())
                    true
                }

                R.id.navigation_notifications -> {
                    loadFragment(NotificationsFragment.getInstance())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}