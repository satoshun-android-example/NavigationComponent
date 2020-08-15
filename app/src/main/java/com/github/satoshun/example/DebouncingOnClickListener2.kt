package com.github.satoshun.example

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.findViewTreeLifecycleOwner

class DebouncingOnClickListener2(
  private val doClick: (View) -> Unit
) : View.OnClickListener {
  override fun onClick(v: View) {
    fun handle(hostView: View) {
      val last = hostView.getLastClickedMs()
      val currentTime = System.currentTimeMillis()
      println("TEST2 $last $currentTime")
      if (currentTime <= last + 10000) {
        return
      }
      hostView.setLastClickedMs(currentTime)
      doClick(v)
    }

    when (val owner = v.findViewTreeLifecycleOwner()) {
      is FragmentActivity -> {
        val rootView = owner.findViewById<View>(android.R.id.content)
        handle(rootView)
      }
      is Fragment -> {
        val rootView = owner.view ?: run {
          doClick(v)
          return
        }
        handle(rootView)
      }
      else -> {
        doClick(v)
      }
    }
  }

  private fun View.getLastClickedMs(): Long =
    getTag(R.id.last_clicked_ms) as? Long ?: 0

  private fun View.setLastClickedMs(last: Long) =
    setTag(R.id.last_clicked_ms, last)
}

fun View.setDebounceClickListener2(doClick: (View) -> Unit) {
  setOnClickListener(DebouncingOnClickListener2(doClick))
}
