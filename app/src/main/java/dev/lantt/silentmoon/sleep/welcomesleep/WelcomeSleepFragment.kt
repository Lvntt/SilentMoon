package dev.lantt.silentmoon.sleep.welcomesleep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.lantt.silentmoon.R
class WelcomeSleepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_sleep, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WelcomeSleepFragment()
    }
}