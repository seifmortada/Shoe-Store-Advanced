package com.example.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginButton.setOnClickListener { goToWelcomeScreen() }
        binding.createAccountButton.setOnClickListener { goToWelcomeWithoutChecking() }
        return binding.root
    }

    fun goToWelcomeWithoutChecking() {
        requireView().findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

    fun goToWelcomeScreen() {
        if (checkFields()) {
            requireView().findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
    }

    fun checkFields(): Boolean {
        binding.apply {
            val emailtext = emailEditText.text
            val passtext = passwordEditText.text

            return if (emailtext.isNullOrEmpty() || passtext.isNullOrEmpty()) {
                toast("Please enter the email or the password").show()
                false
            } else if (!emailtext.contains("@")) {
                toast("Enter Correct Email")
                false
            } else if (passtext.length < 8) {
                toast("Enter strong password at least 8 digits")
                false
            } else true
        }
    }

    fun toast(message: String): Toast {
        return Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
    }

    override fun onStart() {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        super.onStart()
    }

}