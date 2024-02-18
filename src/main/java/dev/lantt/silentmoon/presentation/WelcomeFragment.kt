package dev.lantt.silentmoon.presentation

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentWelcomeBinding
import dev.lantt.silentmoon.utils.setTopMarginInset

class WelcomeFragment : Fragment() {

    // TODO change
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)

        setTopMarginInset(binding.appTitle)

        var username = arguments?.getString("username")
        if (username.isNullOrBlank()) {
            username = "Afsar"
        }
        val spannableString = SpannableString(resources.getString(R.string.welcomeGreetingsText, username))
        val boldString = resources.getString(R.string.welcomeGreetingsTextShort, username)
        val start = 0
        val end = start + boldString.length

        spannableString.setSpan(
            TextAppearanceSpan(context, R.style.welcomeBoldTitleText),
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.greetingsText.text = spannableString

        return binding.root
    }

}