package com.sy.basic3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sy.basic3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var person:Person? = null
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    enum class PersonType{
        PERSON, STUDENT  //열거형
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            makePerson(PersonType.PERSON)
        }
        binding.button2.setOnClickListener {
            makePerson(PersonType.STUDENT)
        }
    }

    fun makePerson(type:PersonType){
        val name = binding.input1.text.toString()
        val age = binding.input2.text.toString().toInt()
        val address = binding.input3.text.toString()



        when (type){
            PersonType.PERSON -> {
                person = Person(name, age, address)
                binding.output1.text = "사람 객체 만들어짐 : ${person?.name}"
                binding.output2.setImageResource(R.drawable.person)

                person?.walk(binding.output1)
            }
            PersonType.STUDENT -> {
                person = Student(name, age, address)
                binding.output1.text = "학생 객체 만들어짐 : ${person?.name}"
                binding.output2.setImageResource(R.drawable.student)

                person?.walk(binding.output1)
            }

        }
    }
}