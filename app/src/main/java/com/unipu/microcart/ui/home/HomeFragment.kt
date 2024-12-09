package com.unipu.microcart.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.unipu.microcart.R
import com.unipu.microcart.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeItemAdapter: HomeItemAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeItemAdapter = HomeItemAdapter(listOf()) { item ->
            val bundle = Bundle().apply {
                putString("name", item.name)
                putDouble("price", item.price)
                putInt("image", item.image)
                putString("description", item.description)
                putStringArray("availableSizes", item.availableSizes)
            }
            findNavController().navigate(R.id.action_navigation_home_to_itemDetailsFragment, bundle)
        }

        binding.recyclerViewHome.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewHome.adapter = homeItemAdapter

        homeViewModel.filteredItems.observe(viewLifecycleOwner) { items ->
            homeItemAdapter.updateItems(items)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { homeViewModel.filterItems(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { homeViewModel.filterItems(it) }
                return false
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}