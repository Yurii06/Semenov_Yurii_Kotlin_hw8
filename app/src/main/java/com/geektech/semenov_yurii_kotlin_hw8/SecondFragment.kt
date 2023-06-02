package com.geektech.semenov_yurii_kotlin_hw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondFragment : Fragment() {

    lateinit var buttonSave: Button
    private lateinit var questionSmoke: EditText
    private lateinit var questionAlcohol: EditText
    private lateinit var questionPassport: EditText

    private lateinit var answersSmoke: Array<String>
    private lateinit var answersAlcohol: Array<String>
    private lateinit var answersPassport: Array<String>

    var isAnswersCorrect = false
    private val bottomYesFragment = YesBottomSheetFragment()
    private val bottomNoFragment = NotBottomSheetFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findViews()
        createArrays()

        buttonSave.setOnClickListener {
            compareAnswers()
        }
    }

    private fun findViews() {
        buttonSave = requireActivity().findViewById(R.id.buttonSave)
        questionSmoke = requireActivity().findViewById(R.id.editTextGPA)
        questionAlcohol = requireActivity().findViewById(R.id.editTextSchool)
        questionPassport = requireActivity().findViewById(R.id.editTextMarriage)
    }

    private fun createArrays() {
        answersSmoke = arrayOf("18", "Восемьнадцать", "После восемнадцати", "После 18")
        answersAlcohol = arrayOf("18", "После восемнадцати", "После 18", "Восемьнадцать")
        answersPassport = arrayOf("Да", "Конечно", "Обязательно", "Yes")
    }

    private fun compareAnswers() {
        checkBlanks()
        if (questionSmoke.text.toString().isEmpty() || questionAlcohol.text.toString()
                .isEmpty() || questionPassport.text.toString().isEmpty()
        ) {
            Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
        } else if (isAnswersCorrect) {
            bottomYesFragment.show(requireActivity().supportFragmentManager, "second")
        } else {
            bottomNoFragment.show(requireActivity().supportFragmentManager, "second")
        }
    }

    private fun checkBlanks() {
        isAnswersCorrect =
            answersSmoke.contains(questionSmoke.text.toString())
        answersAlcohol.contains(questionAlcohol.text.toString())
        answersPassport.contains(questionPassport.text.toString())
    }
}