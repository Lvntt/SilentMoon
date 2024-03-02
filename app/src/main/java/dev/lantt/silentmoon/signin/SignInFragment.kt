package dev.lantt.silentmoon.signin

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.R
import dev.lantt.silentmoon.databinding.FragmentSignInBinding
import dev.lantt.silentmoon.signup.SignUpFragment
import dev.lantt.silentmoon.welcome.WelcomeFragment
import dev.lantt.silentmoon.utils.makeClickableSpannable
import dev.lantt.silentmoon.utils.navigateToFragment
import dev.lantt.silentmoon.utils.setTopPaddingInset

class SignInFragment : Fragment() {

    // TODO change
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.welcomeBack.setTopPaddingInset()

        val spannableString = makeClickableSpannable(
            text = resources.getString(R.string.noAccount),
            clickablePhrase = resources.getString(R.string.signUp),
            phraseColor = ContextCompat.getColor(requireContext().applicationContext,
                R.color.accent
            )
        ) {
            parentFragmentManager.navigateToFragment(SignUpFragment.newInstance())
        }

        with (binding.noAccount) {
            movementMethod = LinkMovementMethod.getInstance()
            text = spannableString
        }
        binding.logInButton.setOnClickListener {
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
            SignInFragment()
    }
}