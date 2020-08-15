package com.github.satoshun.example.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.BasicFragBinding
import com.github.satoshun.example.setDebounceClickListener2

class BasicFragment : Fragment(R.layout.basic_frag) {
  private lateinit var binding: BasicFragBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = BasicFragBinding.bind(view)

    binding.root.setDebounceClickListener2 {
      println("TEST2 BASIC")
    }
  }
}
