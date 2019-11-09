package com.github.satoshun.example.onlydialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.OnlyDialogActBinding

class OnlyDialogActivity : AppCompatActivity() {
  private lateinit var binding: OnlyDialogActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.only_dialog_act)
  }
}
