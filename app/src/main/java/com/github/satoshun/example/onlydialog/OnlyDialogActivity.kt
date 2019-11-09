package com.github.satoshun.example.onlydialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.OnlyDialogActBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OnlyDialogActivity : AppCompatActivity() {
  private lateinit var binding: OnlyDialogActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = OnlyDialogActBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.top.setOnClickListener {
      findNavController(R.id.nav_host_fragment).navigate(R.id.nav_basic_dialog2)

      lifecycleScope.launch {
        delay(3000)

        findNavController(R.id.nav_host_fragment).navigate(R.id.nav_basic_dialog3)
      }
    }
  }
}
