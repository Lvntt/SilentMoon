package dev.lantt.silentmoon

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.lantt.silentmoon.databinding.ActivityMainBinding
import dev.lantt.silentmoon.signinsignup.SignInSignUpFragment
import dev.lantt.silentmoon.utils.UserManager
import dev.lantt.silentmoon.utils.navigateToFragment

class MainActivity : AppCompatActivity(), UserManager {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val userSharedPreferences by lazy {
        getSharedPreferences(USER_SHARED_PREFS_KEY, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.navigateToFragment(SignInSignUpFragment.newInstance())
    }

    override fun getUsername(): String {
        return userSharedPreferences.getString(
            USERNAME_PREFS_KEY,
            null
        ) ?: getString(R.string.defaultUsername)
    }

    override fun setUsername(username: String) {
        userSharedPreferences.edit()
            .putString(USERNAME_PREFS_KEY, username)
            .apply()
    }

    private companion object {
        const val USER_SHARED_PREFS_KEY = "user_shared_prefs_key"
        const val USERNAME_PREFS_KEY = "username_prefs_key"
    }

}