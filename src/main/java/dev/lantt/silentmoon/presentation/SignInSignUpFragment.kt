package dev.lantt.silentmoon.presentation

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignInSignUpBinding
import dev.lantt.silentmoon.utils.makeSpannableString

class SignInSignUpFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignInSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInSignUpBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.appTitle) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updateLayoutParams<MarginLayoutParams> {
                topMargin = insets.top
            }

            WindowInsetsCompat.CONSUMED
        }

        val spannableString = makeSpannableString(
            text = resources.getString(R.string.alreadyHaveAnAccount),
            phrase = resources.getString(R.string.logInText),
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