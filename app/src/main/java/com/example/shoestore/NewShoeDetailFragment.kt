package com.example.shoestore

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentNewShoeDetailBinding
import com.example.shoestore.models.ShoeViewModel

class NewShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentNewShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel

    //Variables for the xml
    private lateinit var name_et: String
    private lateinit var company_et: String
    private var size_et: Double? = 0.0
    private lateinit var description_et: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoe_detail, container, false)
        viewModel =
            ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        binding.viewModelxml = viewModel
        binding.fragment = this@NewShoeDetailFragment
        binding.lifecycleOwner = this

        return binding.root
    }

    fun setData() {
        binding.apply {
            if (ShoeCompanyEditText.text.isNullOrEmpty() || shoeNameEditText.text.isNullOrEmpty() || sizeEt.text.isNullOrEmpty() || descriptionEt.text.isNullOrEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Enter the shoe details correctly",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Assign the edit texts to variables to pass it to the setData Method
                name_et = shoeNameEditText.text.toString()
                company_et = ShoeCompanyEditText.text.toString()
                size_et = (sizeEt.text.toString()).toDouble()
                description_et = descriptionEt.text.toString()
                // Adding the data into the shoe item in the viewModel
                viewModel.addShoe(name_et, company_et, size_et!!, description_et)
                //Navigating back
                requireView().findNavController()
                    .navigate(R.id.action_newShoeDetailFragment_to_listFragment)

            }
        }
    }

    fun back() {
        requireView().findNavController().navigateUp()
    }

    override fun onStart() {
        // Get the ActionBar instance from the hosting activity
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        // Change the ActionBar color
        actionBar!!.title = "Shoe Detalis"
        actionBar.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.blueColor
                )
            )
        )
        actionBar.show()
        super.onStart()
    }
}