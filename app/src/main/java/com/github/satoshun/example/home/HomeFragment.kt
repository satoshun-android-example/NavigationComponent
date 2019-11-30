package com.github.satoshun.example.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.HomeFragBinding

class HomeFragment : Fragment(R.layout.home_frag) {
  private lateinit var binding: HomeFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = HomeFragBinding.bind(view)

    binding.basicDialog.setOnClickListener {
      findNavController().navigate(R.id.nav_basic_dialog)
    }

    binding.onlyDialog.setOnClickListener {
      findNavController().navigate(R.id.nav_only_dialog)
    }

    binding.sample.setOnClickListener {
      findNavController().navigate(R.id.nav_basic)
    }
  }
}
