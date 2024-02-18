package dev.lantt.silentmoon.utils

import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams

fun makeSpannableString(
    text: String,
    phrase: String,
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

    val start = text.indexOf(phrase)
    val end = start + phrase.length

    spannableString.setSpan(
        clickableSpan,
        start,
        end,
        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return spannableString
}

fun setTopMarginInset(view: View) {
    ViewCompat.setOnApplyWindowInsetsListener(view) { v, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = insets.top
        }

        WindowInsetsCompat.CONSUMED
    }
}