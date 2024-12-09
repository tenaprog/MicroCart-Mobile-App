package com.unipu.microcart.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.unipu.microcart.MainActivity
import com.unipu.microcart.R
import com.unipu.microcart.databinding.FragmentItemDetailsBinding

class ItemDetailsFragment : Fragment() {

    private var _binding: FragmentItemDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailsBinding.inflate(inflater, container, false)

        binding.itemName.text = arguments?.getString("name")
        binding.itemPrice.text = "${arguments?.getDouble("price")} EUR"
        arguments?.getInt("image")?.let { binding.itemImage.setImageResource(it) }
        binding.itemDescription.text = arguments?.getString("description")

        val availableSizes = arguments?.getStringArray("availableSizes") ?: emptyArray()
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            availableSizes
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.sizeSpinner.adapter = adapter

        val supportActionBar = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.title = arguments?.getString("name")

        val menu = (requireActivity() as MainActivity).binding.navView.menu
        menu.findItem(R.id.navigation_home)?.isChecked = true

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
