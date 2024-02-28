package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignInBinding
import dev.lantt.silentmoon.utils.makeClickableSpannable
import dev.lantt.silentmoon.utils.setTopMarginInset

class SignInFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        setTopMarginInset(binding.welcomeBack)

        val spannableString = makeClickableSpannable(
            text = resources.getString(R.string.noAccount),
            clickablePhrase = resources.getString(R.string.signUp),
            phraseColor = ContextCompat.getColor(requireContext().applicationContext,
                R.color.accent
            )
        ) {
            navigateToSignUpFragment()
        }

        with (binding.noAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.logInButton.setOnClickListener {
            navigateToWelcomeFragment()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToWelcomeFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentHost, WelcomeFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToSignUpFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentHost, SignUpFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SignInFragment()
    }
}