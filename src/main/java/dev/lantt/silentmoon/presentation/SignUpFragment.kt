package dev.lantt.silentmoon.presentation

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignUpBinding
import dev.lantt.silentmoon.utils.makeSpannableString
import dev.lantt.silentmoon.utils.setTopMarginInset

class SignUpFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        setTopMarginInset(binding.createYourAccount)

        val spannableString = makeSpannableString(
            text = resources.getString(R.string.iHaveReadThePrivacyPolicy),
            phrase = resources.getString(R.string.privacyPolicy),
            phraseColor = ContextCompat.getColor(requireContext().applicationContext,
                R.color.accent
            )
        ) {
            Toast.makeText(
                context,
                resources.getString(R.string.privacyPolicyText),
                Toast.LENGTH_SHORT
            ).show()
        }

        with (binding.noAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.getStartedButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_welcomeFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}