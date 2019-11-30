package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.github.satoshun.example.databinding.AppActBinding

class AppActivity : AppCompatActivity() {
  private lateinit var binding: AppActBinding
  private lateinit var configuration: AppBarConfiguration

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = AppActBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)

//    binding.toolbar.setupWithNavController(findNavController(R.id.nav_host_fragment))

    val navController = findNavController(R.id.nav_host_fragment)
    configuration = AppBarConfiguration(navController.graph) {
      finish()
      true
    }
    setupActionBarWithNavController(navController, configuration)
    navController.addOnDestinationChangedListener { _, destination, _ ->
      if (destination.id in configuration.topLevelDestinations) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
      }
    }

    var suffix = "suf"
    navController.addOnDestinationChangedListener { _, _, _ ->
      supportActionBar?.title = "${supportActionBar?.title} $suffix"
    }

//    binding.toolbar.setNavigationOnClickListener {
//      if (navController.currentDestination?.id in configuration.topLevelDestinations) {
//        finish()
//      } else {
//        navController.popBackStack()
//      }
//    }
  }

  override fun onSupportNavigateUp(): Boolean {
    return findNavController(R.id.nav_host_fragment).navigateUp(configuration)
  }
}
