package dev.lantt.silentmoon

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dev.lantt.silentmoon.presentation.fragments.SignInSignUpFragment
import dev.lantt.silentmoon.utils.UserManager

class MainActivity : AppCompatActivity(), UserManager {

    private val userSharedPreferences by lazy {
        getSharedPreferences(USER_SHARED_PREFS_KEY, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHost, SignInSignUpFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun getUsername(): String {
        return userSharedPreferences.getString(
            USERNAME_PREFS_KEY,
            null
        ) ?: getString(R.string.default_username)
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