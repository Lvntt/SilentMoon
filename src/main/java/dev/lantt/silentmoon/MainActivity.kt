package dev.lantt.silentmoon

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dev.lantt.silentmoon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        val spannableString = makeSpannableString(
            text = resources.getString(R.string.alreadyHaveAnAccount),
            phrase = resources.getString(R.string.logInText),
            phraseColor = ContextCompat.getColor(this, R.color.accent)
        ) {
            Toast.makeText(
                this,
                "Redirect in progress",
                Toast.LENGTH_SHORT
            ).show()
            // TODO navigation
        }

        with (binding.alreadyHaveAnAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
    }

    private fun makeSpannableString(
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
}