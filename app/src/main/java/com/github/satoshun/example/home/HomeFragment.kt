package com.github.satoshun.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.HomeFragBinding

class HomeFragment : Fragment() {
  private lateinit var binding: HomeFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = HomeFragBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.submit.setOnClickListener {
      findNavController().navigate(R.id.nav_basic_dialog)
    }

    binding.onlyDialog.setOnClickListener {
      findNavController().navigate(R.id.nav_only_dialog)
    }
  }
}
