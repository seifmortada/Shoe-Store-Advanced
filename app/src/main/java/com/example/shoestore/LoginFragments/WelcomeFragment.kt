package com.example.shoestore.LoginFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding:FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,container,false)
        binding.goToInstructionsButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_instructionsFragment)
        }
        return binding.root
    }

}
