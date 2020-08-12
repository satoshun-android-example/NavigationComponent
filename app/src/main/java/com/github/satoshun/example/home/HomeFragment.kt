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
      findNavController().navigate(HomeFragmentDirections.navHomeToBasicDialog())
    }

    binding.onlyDialog.setOnClickListener {
      findNavController().navigate(HomeFragmentDirections.navHomeToOnlyDialog())
    }

    binding.sample.setOnClickListener {
      findNavController().navigate(HomeFragmentDirections.navHomeToBasic())
    }
  }
}
