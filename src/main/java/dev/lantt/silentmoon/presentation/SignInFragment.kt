package dev.lantt.silentmoon.presentation

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignInBinding
import dev.lantt.silentmoon.utils.makeSpannableString
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

        val spannableString = makeSpannableString(
            text = resources.getString(R.string.noAccount),
            phrase = resources.getString(R.string.signUp),
            phraseColor = ContextCompat.getColor(requireContext().applicationContext,
                R.color.accent
            )
        ) {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        with (binding.noAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.logInButton.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_welcomeFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}