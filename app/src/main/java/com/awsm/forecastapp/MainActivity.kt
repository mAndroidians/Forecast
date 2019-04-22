package com.awsm.forecastapp

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {


    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar.title = getString(R.string.app_name)
       val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

       // findViewById<BottomNavigationView>(R.id.nav_view)
        //    .setupWithNavController(navController)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.todayFragment -> {
                //textMessage.setText(R.string.title_home)
                this.navController.navigate(R.id.todayFragment)


                return@OnNavigationItemSelectedListener true
            }
            R.id.sevenDayForcastFragment -> {
                //textMessage.setText(R.string.title_dashboard)
                this.navController.navigate(R.id.sevenDayForcastFragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.settingFragment -> {
                //textMessage.setText(R.string.title_notifications)
                this.navController.navigate(R.id.settingFragment)

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }





}
