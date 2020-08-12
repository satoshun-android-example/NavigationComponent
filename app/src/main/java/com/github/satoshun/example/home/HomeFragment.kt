package com.github.satoshun.example.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.HomeFragBinding
import com.github.satoshun.example.setDebounceClickListener

class HomeFragment : Fragment(R.layout.home_frag) {
  private lateinit var binding: HomeFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = HomeFragBinding.bind(view)

    binding.basicDialog.setDebounceClickListener {
      println("TEST basicDialog")
      findNavController().navigate(HomeFragmentDirections.navHomeToBasicDialog())
    }

    binding.onlyDialog.setDebounceClickListener {
      println("TEST onlyDialog")
      findNavController().navigate(HomeFragmentDirections.navHomeToOnlyDialog())
    }

    binding.sample.setDebounceClickListener {
      println("TEST sample")
      findNavController().navigate(HomeFragmentDirections.navHomeToBasic())
    }
  }
}
