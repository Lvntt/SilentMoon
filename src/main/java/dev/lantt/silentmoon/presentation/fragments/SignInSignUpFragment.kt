package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
            findNavController().navigate(R.id.action_signInSignUpFragment_to_signInFragment)
        }

        with (binding.alreadyHaveAnAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInSignUpFragment_to_signUpFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}