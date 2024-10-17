package com.example.fittr_app

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fittr_app.databinding.ActivityMainBinding
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.fittr_app.media_pipe.CameraFragment
import com.example.fittr_app.media_pipe.GalleryFragment
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        // entry fragment is the permissions fragment, which automatically navigates to the camera fragment
        activityMainBinding.navigation.setupWithNavController(navController)
        activityMainBinding.navigation.setOnNavigationItemReselectedListener {
            // ignore the reselection
        }

        // Get the fragment to load from the intent extras
//        val fragmentToLoad:String = intent.getStringExtra("FRAGMENT_TO_LOAD").toString()
//
//        // Load the appropriate fragment
//        when (fragmentToLoad) {
//            "CameraFragment" -> navigateToCameraFragment()
//            "GalleryFragment" -> navigateToGalleryFragment()
//        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish();
    }

    private fun navigateToCameraFragment() {
        navController.navigate(R.id.action_permissions_to_camera)
    }

    private fun navigateToGalleryFragment() {
        //navController.navigate(R.id.) // Assuming you have an action defined for this
    }


}