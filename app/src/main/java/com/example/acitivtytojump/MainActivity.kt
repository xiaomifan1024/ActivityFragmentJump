package com.example.acitivtytojump

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.acitivtytojump.databinding.ActivityMainBinding

import android.R.attr

import android.view.View

import android.R.attr.button
import android.graphics.Insets.add
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.example.acitivtytojump.ui.dashboard.DashboardFragment
import com.example.acitivtytojump.ui.home.HomeFragment
import com.example.acitivtytojump.ui.notifications.NotificationsFragment


class MainActivity : AppCompatActivity() , BottomNavigationBar.OnTabSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationBar = binding.navView
        with(navView){
            setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT)
            setMode(BottomNavigationBar.MODE_FIXED)
            inActiveColor = R.color.gray
            addItem(BottomNavigationItem(R.mipmap.home,R.string.title_home))
            addItem(BottomNavigationItem(R.mipmap.history,R.string.title_history))
            addItem(BottomNavigationItem(R.mipmap.notification,R.string.title_notifications))
            setFirstSelectedPosition(0)// デフォルトのTab
            initialise();
        }
        navView.setTabSelectedListener(this)
        //初期化
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_ll, HomeFragment());
        transaction.commit()

    }

    override fun onTabSelected(position: Int) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        when (position){
            0 -> {
                transaction.replace(R.id.fragment_ll, HomeFragment())
                transaction.commit()
            }
            1 -> {
                transaction.replace(R.id.fragment_ll, DashboardFragment())
                transaction.commit()
            }
            2 -> {
                transaction.replace(R.id.fragment_ll, NotificationsFragment())
                transaction.commit()
            }
        }
    }

    override fun onTabUnselected(position: Int) {

    }

    override fun onTabReselected(position: Int) {

    }
}