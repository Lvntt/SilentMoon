package dev.lantt.silentmoon

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.lantt.silentmoon.databinding.FragmentSignInSignUpBinding

class SignInSignUpFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignInSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInSignUpBinding.inflate(inflater, container, false)

        val spannableString = makeSpannableString(
            text = resources.getString(R.string.alreadyHaveAnAccount),
            phrase = resources.getString(R.string.logInText),
            phraseColor = ContextCompat.getColor(requireContext().applicationContext, R.color.accent)
        ) {
            findNavController().navigate(R.id.action_signInSignUpFragment_to_signUpFragment)
        }

        with (binding.alreadyHaveAnAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInSignUpFragment_to_signInFragment)
        }

        return binding.root
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}