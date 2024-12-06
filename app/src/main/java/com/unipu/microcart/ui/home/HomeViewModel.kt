package com.unipu.microcart.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unipu.microcart.Item
import com.unipu.microcart.getItemList

class HomeViewModel : ViewModel() {

    private val _itemList = MutableLiveData<List<Item>>().apply {
        value = getItemList()
    }

    private val _filteredItems = MutableLiveData<List<Item>>().apply {
        value = _itemList.value
    }
    val filteredItems: LiveData<List<Item>> = _filteredItems

    fun filterItems(query: String) {
        val filtered = _itemList.value?.filter {
            it.name.contains(query, ignoreCase = true)
        }
        _filteredItems.value = filtered
    }
}
