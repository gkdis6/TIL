package com.sy.basic2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sy.basic2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var name:String = "" //클래스에서 만들어진 변수는 초기화를 꼭 해야함

    companion object{
        const val SANGYONG = "sangyong"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            name = binding.nameInput.text.toString()
            var mobile = binding.mobileInput.text.toString()

            Toast.makeText(applicationContext, "이름 : $name, 전화번호 : $mobile", Toast.LENGTH_LONG).show()

        }
        sum(10, 20, 40)
        println(add (30, 50))
        println(square(12))
        
    }
    fun sum(vararg inputs:Int): Int {
        var output = 0
        for (num in inputs){
            output = output + num
        }
        return output
    }
    fun add(a:Int,b:Int) = a + b
    val square = {a:Int -> a*a} //이게 람다식
    val template1 = {a:String, b:Int -> "이름은 ${a}이고 나이는 ${b}이다."}
    val calc = {a:Int, b:Int, c:(Int,Int)->Int -> c(a,b)}

}