package com.unipu.microcart.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.unipu.microcart.Item
import com.unipu.microcart.MainActivity
import com.unipu.microcart.R
import com.unipu.microcart.databinding.FragmentItemDetailsBinding
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

class ItemDetailsFragment : Fragment() {

    private var _binding: FragmentItemDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailsBinding.inflate(inflater, container, false)

        val item = Item(
            name = arguments?.getString("name") ?: "Unknown",
            description = arguments?.getString("description") ?: "No description available",
            image = arguments?.getInt("image") ?: R.mipmap.ic_launcher,
            availableSizes = arguments?.getStringArray("availableSizes") ?: emptyArray(),
            price = arguments?.getDouble("price") ?: 0.0,
            chosenSize = ""
        )

        binding.itemName.text = item.name
        binding.itemPrice.text = "${item.price} EUR"
        binding.itemImage.setImageResource(item.image)
        binding.itemDescription.text = item.description

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            item.availableSizes
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.sizeSpinner.adapter = adapter

        binding.buttonAddToCart.setOnClickListener {
            item.chosenSize = binding.sizeSpinner.selectedItem?.toString() ?: "Not selected"
            saveItemToStorage(item)
        }

        val supportActionBar = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.title = item.name

        val menu = (requireActivity() as MainActivity).binding.navView.menu
        menu.findItem(R.id.navigation_home)?.isChecked = true

        return binding.root
    }

    private fun saveItemToStorage(item: Item) {
        try {
            val externalStorage = requireContext().getExternalFilesDir(null)
            val file = File(externalStorage, "microcart.json")

            if (!file.exists()) {
                file.createNewFile()
            }

            val existingData = if (file.length() > 0) {
                file.bufferedReader().use { it.readText() }
            } else {
                "[]"
            }

            val jsonArray = JSONArray(existingData)

            val newItem = JSONObject().apply {
                put("name", item.name)
                put("description", item.description)
                put("price", item.price)
                put("image", item.image)
                put("availableSizes", JSONArray(item.availableSizes))
                put("chosenSize", item.chosenSize)
            }

            jsonArray.put(newItem)

            PrintWriter(FileWriter(file)).use { writer ->
                writer.write(jsonArray.toString())
            }

            Toast.makeText(requireContext(), "Item saved to cart!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Failed to save item", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
