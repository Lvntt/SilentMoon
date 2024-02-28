package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignInSignUpBinding
import dev.lantt.silentmoon.utils.makeClickableSpannable
import dev.lantt.silentmoon.utils.setTopMarginInset

class SignInSignUpFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignInSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInSignUpBinding.inflate(inflater, container, false)

        setTopMarginInset(binding.appTitle)

        val spannableString = makeClickableSpannable(
            text = resources.getString(R.string.alreadyHaveAnAccount),
            clickablePhrase = resources.getString(R.string.logInText),
            phraseColor = ContextCompat.getColor(requireContext().applicationContext,
                R.color.accent
            )
        ) {
            navigateToSignInFragment()
        }

        with (binding.alreadyHaveAnAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.signUpButton.setOnClickListener {
            navigateToSignUpFragment()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun navigateToSignInFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentHost, SignInFragment.newInstance())
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
            SignInSignUpFragment()
    }

}