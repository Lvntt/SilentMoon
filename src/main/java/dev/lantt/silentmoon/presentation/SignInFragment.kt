package dev.lantt.silentmoon.presentation

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.navigation.fragment.findNavController
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignInBinding
import dev.lantt.silentmoon.utils.makeSpannableString

class SignInFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.welcomeBack) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = insets.top
            }

            WindowInsetsCompat.CONSUMED
        }

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