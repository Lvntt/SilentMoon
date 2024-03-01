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
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class SignInSignUpFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignInSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInSignUpBinding.inflate(inflater, container, false)

        binding.appTitle.setTopPaddingInset()

        val spannableString = makeClickableSpannable(
            text = resources.getString(R.string.alreadyHaveAnAccount),
            clickablePhrase = resources.getString(R.string.logInText),
            phraseColor = ContextCompat.getColor(requireContext().applicationContext,
                R.color.accent
            )
        ) {
            parentFragmentManager.navigateToFragment(SignInFragment.newInstance())
        }

        with (binding.alreadyHaveAnAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.signUpButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(SignUpFragment.newInstance())
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
            SignInSignUpFragment()
    }

}