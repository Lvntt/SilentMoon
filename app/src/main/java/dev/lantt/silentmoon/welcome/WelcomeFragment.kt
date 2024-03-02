package dev.lantt.silentmoon.welcome

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
import dev.lantt.silentmoon.choosetopic.ChooseTopicFragment
import dev.lantt.silentmoon.utils.UserManager
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class WelcomeFragment : Fragment() {

    // TODO change
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val userManager = requireActivity() as UserManager
        val username = userManager.getUsername()

        _binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)

        binding.appTitle.setTopPaddingInset()

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
        binding.getStartedButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(ChooseTopicFragment.newInstance())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WelcomeFragment()
    }

}