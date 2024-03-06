package dev.lantt.silentmoon.utils

import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import androidx.annotation.IdRes
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dev.lantt.silentmoon.R

fun makeClickableSpannable(
    text: String,
    clickablePhrase: String,
    phraseColor: Int,
    listener: View.OnClickListener
): SpannableString {
    val spannableString = SpannableString(text)
    val clickableSpan = object : ClickableSpan() {
        override fun updateDrawState(drawState: TextPaint) {
            drawState.color = phraseColor
            drawState.isUnderlineText = false
        }
        override fun onClick(view: View) {
            listener.onClick(view)
        }
    }

    val start = text.indexOf(clickablePhrase)
    val end = start + clickablePhrase.length

    spannableString.setSpan(
        clickableSpan,
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return spannableString
}

fun View.setTopPaddingInset() {
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        this.setPadding(this.paddingLeft, insets.top, this.paddingRight, this.paddingBottom)

        WindowInsetsCompat.CONSUMED
    }
}

fun FragmentManager.navigateToFragment(
    fragment: Fragment,
    @IdRes fragmentHostId: Int = R.id.fragmentHost
) {
    beginTransaction()
        .replace(fragmentHostId, fragment)
        .addToBackStack(null)
        .commit()
}

fun FragmentManager.navigateToFragmentWithBottomBar(
    fragment: Fragment
) {
    navigateToFragment(fragment, R.id.bottomNavigationFragmentHost)
}