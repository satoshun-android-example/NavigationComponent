/**
 * borrow from https://github.com/JakeWharton/butterknife
 */
package com.github.satoshun.example

import android.os.Handler
import android.os.Looper
import android.view.View

class DebouncingOnClickListener(private val doClick: (View) -> Unit) : View.OnClickListener {
  override fun onClick(v: View) {
    if (enabled) {
      println("TEST deboucing")
      enabled = false

      MAIN.post(ENABLE_AGAIN)
      doClick(v)
    } else {
      println("TEST deboucing ignore")
    }
  }

  companion object {
    private val ENABLE_AGAIN = Runnable {
      println("TEST deboucing enabled")
      enabled = true
    }
    private val MAIN = Handler(Looper.getMainLooper())

    var enabled = true
  }
}

fun View.setDebounceClickListener(doClick: (View) -> Unit) {
  setOnClickListener(DebouncingOnClickListener(doClick))
}
