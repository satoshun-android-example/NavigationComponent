package com.github.satoshun.example

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DebouncingOnClickListener3(
  private val doClick: suspend (View) -> Unit
) : View.OnClickListener {
  companion object {
    private val mutex = Mutex()
  }

  override fun onClick(v: View) {
    v.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
      if (!mutex.tryLock()) return@launch
      doClick(v)
      mutex.unlock()
    }
  }

  private fun View.getLastClickedMs(): Long =
    getTag(R.id.last_clicked_ms) as? Long ?: 0

  private fun View.setLastClickedMs(last: Long) =
    setTag(R.id.last_clicked_ms, last)
}

class ViewMM {
  suspend fun hoge() {
    // ...
  }
}

fun test(v: View) {
  v.setDebounceClickListener3 {

  }
}

fun View.setDebounceClickListener3(
  doClick: suspend (View) -> Unit
) {
  setOnClickListener(DebouncingOnClickListener3(doClick))
}
