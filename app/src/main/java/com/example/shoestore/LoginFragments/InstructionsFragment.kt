package com.example.shoestore.LoginFragments

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        binding.goToShoeListButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_instructionsFragment_to_listFragment)
        }
        return binding.root
    }

    override fun onStart() {
        // Get the ActionBar instance from the hosting activity
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        // Change the ActionBar color
        actionBar!!.title="Instructions"
        actionBar.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(requireContext(),R.color.blueColor)))
        actionBar.show()
        super.onStart()
    }

}