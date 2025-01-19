package com.unipu.microcart.ui.profile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.unipu.microcart.databinding.FragmentProfileBinding
import org.json.JSONObject
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var street: EditText
    private lateinit var number: EditText
    private lateinit var city: EditText
    private lateinit var country: EditText
    private lateinit var phone: EditText
    private lateinit var revertButton: Button
    private lateinit var saveButton: Button

    private var originalData: Map<String, String> = mapOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        firstName = binding.editFirstName
        lastName = binding.editLastName
        street = binding.editStreet
        number = binding.editNumber
        city = binding.editCity
        country = binding.editCountry
        phone = binding.editPhone
        revertButton = binding.btnRevertChanges
        saveButton = binding.btnSave

        saveButton.isEnabled = false
        revertButton.isEnabled = false

        originalData = loadFromFile()
        populateFields(originalData)

        val watcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkForChanges()
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        listOf(firstName, lastName, street, number, city, country, phone).forEach {
            it.addTextChangedListener(watcher)
        }

        saveButton.setOnClickListener {
            saveToFile()
            Toast.makeText(requireContext(), "Changes saved!", Toast.LENGTH_SHORT).show()
            originalData = getCurrentData()
            saveButton.isEnabled = false
            revertButton.isEnabled = false
        }

        revertButton.setOnClickListener {
            populateFields(originalData)
            saveButton.isEnabled = false
            revertButton.isEnabled = false
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun populateFields(data: Map<String, String>) {
        firstName.setText(data["firstName"])
        lastName.setText(data["lastName"])
        street.setText(data["street"])
        number.setText(data["number"])
        city.setText(data["city"])
        country.setText(data["country"])
        phone.setText(data["phone"])
    }

    private fun getCurrentData(): Map<String, String> {
        return mapOf(
            "firstName" to firstName.text.toString(),
            "lastName" to lastName.text.toString(),
            "street" to street.text.toString(),
            "number" to number.text.toString(),
            "city" to city.text.toString(),
            "country" to country.text.toString(),
            "phone" to phone.text.toString()
        )
    }

    private fun checkForChanges() {
        val currentData = getCurrentData()
        val hasChanges = currentData != originalData
        saveButton.isEnabled = hasChanges
        revertButton.isEnabled = hasChanges
    }

    private fun saveToFile() {
        val externalStorage = requireContext().getExternalFilesDir(null)
        val file = File(externalStorage, "userdata.json")

        if (!file.exists()) {
            file.createNewFile()
        }

        val currentData = getCurrentData()
        val jsonObject = JSONObject(currentData)
        FileWriter(file).use { writer ->
            writer.write(jsonObject.toString())
            writer.flush()
        }

    }

    private fun loadFromFile(): Map<String, String> {
        val externalStorage = requireContext().getExternalFilesDir(null)
        val file = File(externalStorage, "userdata.json")

        if (!file.exists()) {
            val defaultData = mapOf(
                "firstName" to "Tena",
                "lastName" to "Radanovic",
                "street" to "Ulica shoppinga",
                "number" to "34",
                "city" to "Zagreb",
                "country" to "Hrvatska",
                "phone" to "0989582563"
            )
            val jsonObject = JSONObject(defaultData)
            FileWriter(file).use { writer ->
                writer.write(jsonObject.toString())
                writer.flush()
            }
            return defaultData
        }

        FileReader(file).use { reader ->
            val jsonObject = JSONObject(reader.readText())
            return mapOf(
                "firstName" to jsonObject.optString("firstName"),
                "lastName" to jsonObject.optString("lastName"),
                "street" to jsonObject.optString("street"),
                "number" to jsonObject.optString("number"),
                "city" to jsonObject.optString("city"),
                "country" to jsonObject.optString("country"),
                "phone" to jsonObject.optString("phone")
            )
        }
    }
}
