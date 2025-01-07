package com.unipu.microcart.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.unipu.microcart.Item
import com.unipu.microcart.databinding.FragmentCartBinding
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val cartItems = mutableListOf<Item>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)

        loadCartItems()
        val cartAdapter = CartItemAdapter(cartItems) { item ->
            deleteItem(item)
        }
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = cartAdapter

        return binding.root
    }

    private fun loadCartItems() {
        val file = File(requireContext().getExternalFilesDir(null), "microcart.json")

        if (file.exists() && file.length() > 0) {
            val jsonData = file.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(jsonData)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val item = Item(
                    name = jsonObject.getString("name"),
                    description = jsonObject.getString("description"),
                    image = jsonObject.getInt("image"),
                    availableSizes = jsonObject.getJSONArray("availableSizes").let { sizes ->
                        Array(sizes.length()) { sizes.getString(it) }
                    },
                    price = jsonObject.getDouble("price"),
                    chosenSize = jsonObject.getString("chosenSize")
                )
                cartItems.add(item)
            }
        }
    }

    private fun deleteItem(item: Item) {
        cartItems.remove(item)
        binding.cartRecyclerView.adapter?.notifyDataSetChanged()
        saveItemsToStorage()
    }

    private fun saveItemsToStorage() {
        try {
            val externalStorage = requireContext().getExternalFilesDir(null)
            val file = File(externalStorage, "microcart.json")

            if (!file.exists()) {
                file.createNewFile()
            }

            val jsonArray = JSONArray()

            for (item in cartItems) {
                val newItem = JSONObject().apply {
                    put("name", item.name)
                    put("description", item.description)
                    put("price", item.price)
                    put("image", item.image)
                    put("availableSizes", JSONArray(item.availableSizes))
                    put("chosenSize", item.chosenSize)
                }
                jsonArray.put(newItem)
            }

            PrintWriter(FileWriter(file)).use { writer ->
                writer.write(jsonArray.toString())
            }

            Toast.makeText(requireContext(), "Item deleted from cart!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(requireContext(), "Failed to delete item", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}