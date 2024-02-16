package dev.lantt.silentmoon.utils

import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

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