package dev.lantt.silentmoon

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.lantt.silentmoon.databinding.ActivityMainBinding
import dev.lantt.silentmoon.home.HomeFragment
import dev.lantt.silentmoon.signinsignup.SignInSignUpFragment
import dev.lantt.silentmoon.utils.NavigationManager
import dev.lantt.silentmoon.utils.UserManager

class MainActivity : AppCompatActivity(), UserManager, NavigationManager {

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

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHost, SignInSignUpFragment.newInstance())
            .addToBackStack(null)
            .commit()


        // TODO work with back button and back stack
        val bottomNavigationBar = binding.bottomNavigationBar
        bottomNavigationBar.setOnItemSelectedListener { item ->
            var newFragment: Fragment = HomeFragment.newInstance()

            when (item.itemId) {
                R.id.bottom_navigation_home -> newFragment = HomeFragment.newInstance()
                R.id.bottom_navigation_sleep -> newFragment = SignInSignUpFragment.newInstance()
                R.id.bottom_navigation_meditate -> newFragment = SignInSignUpFragment.newInstance()
                R.id.bottom_navigation_music -> newFragment = SignInSignUpFragment.newInstance()
                R.id.bottom_navigation_profile -> newFragment = SignInSignUpFragment.newInstance()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentHost, newFragment)
                .commit()

            return@setOnItemSelectedListener true
        }
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

    override fun showBottomNavigationBar() {
        binding.bottomNavigationBar.visibility = View.VISIBLE
    }

    override fun hideBottomNavigationBar() {
        binding.bottomNavigationBar.visibility = View.GONE
    }

}