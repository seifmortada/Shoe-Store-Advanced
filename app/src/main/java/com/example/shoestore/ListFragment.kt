package com.example.shoestore

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoestore.databinding.FragmentListBinding
import com.example.shoestore.models.ShoeViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    private lateinit var viewModel: ShoeViewModel

    private lateinit var layout: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        layout = binding.layoutList

        binding.fragment = this@ListFragment
        binding.lifecycleOwner = this
        // Observing the shoeList in the viewModel to update the items
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { item ->

            // Adding a new view for every new shoe item in the Linear layout
            item.forEach { shoe ->
                val itemView = inflater.inflate(R.layout.shoe_item, container, false)
                val name = itemView.findViewById<TextView>(R.id.name_edited)
                val comp = itemView.findViewById<TextView>(R.id.company_editedtext)
                val size = itemView.findViewById<TextView>(R.id.size_editedtext)
                val descrip = itemView.findViewById<TextView>(R.id.description_editedtext)
                name.text = shoe.name
                comp.text = shoe.company
                size.text = shoe.size.toString()
                descrip.text = shoe.description
                layout.addView(itemView)


            }
        })

        @Suppress("DEPRECATION")
        setHasOptionsMenu(true)
        return binding.root
    }

     fun addNewShoe() {
        requireView().findNavController()
            .navigate(R.id.action_listFragment_to_newShoeDetailFragment)

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.signout_menu, menu)
        @Suppress("DEPRECATION")
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Navigation.findNavController(requireView())
            .navigate(R.id.action_listFragment_to_loginFragment)
        @Suppress("DEPRECATION")
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        // Get the ActionBar instance from the hosting activity
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        // Change the ActionBar color
        actionBar!!.title = "Shoes List"
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