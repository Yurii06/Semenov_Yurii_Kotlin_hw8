package com.geektech.semenov_yurii_kotlin_hw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    private lateinit var age : EditText
    private lateinit var name : EditText
    private lateinit var lastName : EditText
    private lateinit var buttonNext : Button

    private val bottomFragment = NotBottomSheetFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findViews()

        buttonNext.setOnClickListener{
            checkAnswers()
        }
    }

    private fun findViews() {
        age = requireActivity().findViewById(R.id.editTextAge)
        name = requireActivity().findViewById(R.id.editTextName)
        lastName = requireActivity().findViewById(R.id.editTextLastName)
        buttonNext = requireActivity().findViewById(R.id.buttonNext)
    }

    private fun checkAnswers() {
        if(name.text.toString().isEmpty() || lastName.text.toString().isEmpty() || age.text.toString().isEmpty()) {
            Toast.makeText(context, "Заполните все поля!", Toast.LENGTH_SHORT).show()
        } else if(age.text.toString().toInt() == 18 || age.text.toString().toInt() > 18) {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        else {
            bottomFragment.show(requireActivity().supportFragmentManager, "main")
        }
    }
}