package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.github.satoshun.example.databinding.AppActBinding

class AppActivity : AppCompatActivity() {
  private lateinit var binding: AppActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = AppActBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
//    binding.toolbar.setupWithNavController(findNavController(R.id.nav_host_fragment))
//    lifecycleScope.launch {
//      delay(3000)
//    }

    val navController = findNavController(R.id.nav_host_fragment)
    setupActionBarWithNavController(navController)
    navController.addOnDestinationChangedListener { controller, destination, arguments ->
      if (destination.id == R.id.nav_home) {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
      } else {
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
      }
    }
  }
}
