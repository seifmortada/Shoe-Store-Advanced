package com.example.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: MutableLiveData<MutableList<Shoe>> get() = _shoeList


    init {
        _shoeList.value = mutableListOf()
    }

    // Function to set the coming data from the fragment to the Shoe List


        fun addShoe(name: String, company: String, size: Double, desc: String) {
            val shoe = Shoe(name, size, company, desc)
            val currentList = _shoeList.value ?: mutableListOf()
            currentList.add(shoe)
            _shoeList.value = currentList
        }
    }

