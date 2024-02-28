package dev.lantt.silentmoon.presentation.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignUpBinding
import dev.lantt.silentmoon.utils.UserManager
import dev.lantt.silentmoon.utils.makeClickableSpannable
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopMarginInset

class SignUpFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val userManager = requireActivity() as UserManager

        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        setTopMarginInset(binding.createYourAccount)

        val spannableString = makeClickableSpannable(
            text = resources.getString(R.string.iHaveReadThePrivacyPolicy),
            clickablePhrase = resources.getString(R.string.privacyPolicy),
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
            val usernameInput = binding.nameInput.editText?.text
            val username = if (usernameInput.isNullOrEmpty()) getString(R.string.defaultUsername)
                else usernameInput.toString()

            userManager.setUsername(username)

            parentFragmentManager.navigateToFragment(WelcomeFragment.newInstance())
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
            SignUpFragment()
    }

}